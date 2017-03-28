package com.illengineer.combinations;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import java.io.*;

public class Combinator
	implements ActionListener {

    CombinationFrame frame;
    Clipboard clipboard;
    JFileChooser fileChooser;
    File outputFile;
    String [] elements;
    boolean saveNames;
    
    Combinator() {
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {}

	frame = new CombinationFrame();
	frame.listButton.addActionListener(this);
	frame.copyButton.addActionListener(this);
	frame.setNamesButton.addActionListener(this);
	msg("Choose your values and click 'List Combinations'\n\n" +
	    "You can set the names of your elements (your \"teams\")\n" +
	    "by clicking 'Set Element Names...'\n\n" +
	    "If you would like to save the list to a file, for\n" +
	    "instance if it will be very long, check the\n" + 
	    "'Save Output to File' checkbox.");
	frame.copyButton.setEnabled(false);
	frame.fileOutputCheck.setSelected(false);
	frame.fileOutputCheck.addActionListener(this);
	frame.setVisible(true);
	clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	frame.namesOkayButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source == frame.listButton) {
	    int set_size = 0, choice_size = 0;

	    msg("Generating combinations...");
	    set_size = ((Integer)frame.totalSpinner.getValue()).intValue();
	    choice_size = ((Integer)frame.choiceSpinner.getValue()).intValue();
	    CombinationGenerator cg;
	    try {
		cg = new CombinationGenerator (set_size, choice_size);
	    } catch (IllegalArgumentException ex) {
		msg("You can't generate combinations for those values.");
		return;
	    }

	    ensureSetSizeElements(set_size);
	    int [] indices;
	    if (!frame.fileOutputCheck.isSelected()) {
		// We fill the text area with the list of combinations
		StringBuilder sb = new StringBuilder(4096);
		while (cg.hasMore()) {
		    indices = cg.getNext();
		    for (int i = 0; i < choice_size; i++) {
			if (i != 0) sb.append(", ");
			sb.append(elements[indices[i]]);
		    }
		    sb.append("\n");
		}
		msg(sb.toString());
		frame.copyButton.setEnabled(true);
	    } else {
		// We write the list of combinations to the previously selected file
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
		    while (cg.hasMore()) {
			indices = cg.getNext();
			for (int i = 0; i < choice_size; i++) {
			    if (i != 0) out.print(", ");
			    out.print(elements[indices[i]]);
			}
			out.println();
		    }
		    out.close();
		    msg("Combinations saved to " + outputFile.getName());
		} catch (IOException ex) {
		    msg("There was an IO error trying to write to the file.");
		}
	    }
	} else if (source == frame.copyButton) {
	    StringSelection ss = new StringSelection(frame.messageArea.getText());
	    clipboard.setContents(ss, ss);
	} else if (source == frame.fileOutputCheck) {
	    frame.copyButton.setEnabled(false);
	    if (frame.fileOutputCheck.isSelected()) {
		if (fileChooser == null)
		    fileChooser = new JFileChooser();
		int ret = fileChooser.showSaveDialog(frame);
		if (ret == JFileChooser.APPROVE_OPTION) {
		    outputFile = fileChooser.getSelectedFile();
		    msg("Will send output to " + outputFile.getName());
		} else {
		    frame.fileOutputCheck.doClick();
		}
	    } else {
		msg(null);
	    }
	} else if (source == frame.setNamesButton) {
	    saveNames = false;
	    frame.namesDialog.setVisible(true); // blocks until dialog is closed
	    if (saveNames) {
		String text = frame.namesArea.getText();
		if (text != null) {
		    String [] lines = text.split("\\n");
		    elements = new String[lines.length];
		    int element_idx = 0;
		    for (int i = 0; i < lines.length; i++) {
			if (lines[i].length() != 0)
			    elements[element_idx++] = lines[i];
		    }
		    frame.totalSpinner.setValue(Integer.valueOf(element_idx));
		}
	    }
	} else if (source == frame.namesOkayButton) {
	    saveNames = true;
	    frame.namesDialog.setVisible(false);
	}
    }
    
    private void msg(String s) {
	frame.messageArea.setText(s);
    }
    
    private void ensureSetSizeElements(int size) {
	int old_length = elements == null ? 0 : elements.length;
	String[] e = new String[size];
	for (int cntr = 0; cntr < size; cntr++) {
	    if (cntr < old_length && elements[cntr] != null)
		e[cntr] = elements[cntr];
	    else
		e[cntr] = "#" + Integer.toString(cntr+1);
	}
	elements = e;
    }
    
    public static void main (String [] args) {
	Combinator c = new Combinator();
    }
}
