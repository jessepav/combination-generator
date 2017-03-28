package com.illengineer.combinations;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Feb 27 20:44:51 EST 2009
 */



/**
 * @author Jesse Pavel
 */
public class CombinationFrame extends JFrame {
	public CombinationFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		panel1 = new JPanel();
		label1 = new JLabel();
		totalSpinner = new JSpinner();
		setNamesButton = new JButton();
		label2 = new JLabel();
		choiceSpinner = new JSpinner();
		scrollPane1 = new JScrollPane();
		messageArea = new JTextArea();
		buttonBar = new JPanel();
		label3 = new JLabel();
		copyButton = new JButton();
		listButton = new JButton();
		fileOutputCheck = new JCheckBox();
		namesDialog = new JDialog(this);
		panel2 = new JPanel();
		label4 = new JLabel();
		scrollPane2 = new JScrollPane();
		namesArea = new JTextArea();
		panel3 = new JPanel();
		namesOkayButton = new JButton();

		//======== this ========
		setTitle("Combination Generator");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(0, 8));

		//======== dialogPane ========
		{
		    dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
		    dialogPane.setLayout(new BorderLayout());

		    //======== contentPanel ========
		    {
			contentPanel.setLayout(new BorderLayout(3, 3));

			//======== panel1 ========
			{
			    panel1.setLayout(new GridBagLayout());
			    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
			    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0};
			    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
			    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

			    //---- label1 ----
			    label1.setText("Number of Elements in Total:");
			    panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			    //---- totalSpinner ----
			    totalSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
			    totalSpinner.setPreferredSize(new Dimension(55, 25));
			    panel1.add(totalSpinner, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			    //---- setNamesButton ----
			    setNamesButton.setText("Set Element Names...");
			    panel1.add(setNamesButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			    //---- label2 ----
			    label2.setText("Number to choose each time");
			    panel1.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			    //---- choiceSpinner ----
			    choiceSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
			    choiceSpinner.setPreferredSize(new Dimension(55, 25));
			    panel1.add(choiceSpinner, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));
			}
			contentPanel.add(panel1, BorderLayout.NORTH);

			//======== scrollPane1 ========
			{
			    scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			    //---- messageArea ----
			    messageArea.setEditable(false);
			    messageArea.setFocusable(false);
			    scrollPane1.setViewportView(messageArea);
			}
			contentPanel.add(scrollPane1, BorderLayout.CENTER);
		    }
		    dialogPane.add(contentPanel, BorderLayout.CENTER);

		    //======== buttonBar ========
		    {
			buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
			buttonBar.setLayout(new GridBagLayout());
			((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 0, 80};
			((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

			//---- label3 ----
			label3.setText("by Jesse Pavel (jpavel@alum.mit.edu)");
			label3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			buttonBar.add(label3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
			    new Insets(0, 0, 5, 5), 0, 0));

			//---- copyButton ----
			copyButton.setText("Copy to Clipboard");
			buttonBar.add(copyButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 5, 5), 0, 0));

			//---- listButton ----
			listButton.setText("List Combinations");
			buttonBar.add(listButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 5, 0), 0, 0));

			//---- fileOutputCheck ----
			fileOutputCheck.setText("Save output to file");
			buttonBar.add(fileOutputCheck, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 0, 0), 0, 0));
		    }
		    dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(525, 470);
		setLocationRelativeTo(getOwner());

		//======== namesDialog ========
		{
		    namesDialog.setTitle("Element Names");
		    namesDialog.setModal(true);
		    Container namesDialogContentPane = namesDialog.getContentPane();
		    namesDialogContentPane.setLayout(new BorderLayout());

		    //======== panel2 ========
		    {
			panel2.setBorder(new EmptyBorder(7, 7, 7, 7));
			panel2.setLayout(new GridBagLayout());
			((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 310, 0, 0};
			((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

			//---- label4 ----
			label4.setText("Enter the names for your elements (1 name per row)");
			panel2.add(label4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 10, 0), 0, 0));

			//======== scrollPane2 ========
			{
			    scrollPane2.setViewportView(namesArea);
			}
			panel2.add(scrollPane2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 10, 0), 0, 0));

			//======== panel3 ========
			{
			    panel3.setLayout(new FlowLayout());

			    //---- namesOkayButton ----
			    namesOkayButton.setText("Use These Names");
			    panel3.add(namesOkayButton);
			}
			panel2.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
			    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			    new Insets(0, 0, 0, 0), 0, 0));
		    }
		    namesDialogContentPane.add(panel2, BorderLayout.CENTER);
		    namesDialog.pack();
		    namesDialog.setLocationRelativeTo(namesDialog.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	JPanel dialogPane;
	JPanel contentPanel;
	JPanel panel1;
	JLabel label1;
	JSpinner totalSpinner;
	JButton setNamesButton;
	JLabel label2;
	JSpinner choiceSpinner;
	JScrollPane scrollPane1;
	JTextArea messageArea;
	JPanel buttonBar;
	JLabel label3;
	JButton copyButton;
	JButton listButton;
	JCheckBox fileOutputCheck;
	JDialog namesDialog;
	JPanel panel2;
	JLabel label4;
	JScrollPane scrollPane2;
	JTextArea namesArea;
	JPanel panel3;
	JButton namesOkayButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
