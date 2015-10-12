package namtran.hust.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SimpleCalculate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField resultJText;
	private double tempNumbers1 = 0;
	private double tempNumbers2 = 0;
	private byte function = -1;
	private boolean recentEnter, recentFunction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SimpleCalculate();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalculate() {
		// create frame
		setTitle("Calculator");
		setLocationByPlatform(isLocationByPlatform());
		setSize(230, 330);
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		// create number buttons
		JButton[] numberButtons = new JButton[10];
		for (int i = 9; i >= 0; i--)
			numberButtons[i] = new JButton(Integer.toString(i));

		JButton enterButton = new JButton("Enter");
		JButton cButton = new JButton("C");
		JButton multiplyButton = new JButton("*");
		JButton divideButton = new JButton("/");
		JButton addButton = new JButton("+");
		JButton substractButton = new JButton("-");

		// create text field to display
		resultJText = new JTextField("0");
		resultJText.setPreferredSize(new Dimension(180, 25));
		resultJText.setBackground(Color.WHITE);
		resultJText.setEnabled(false);
		resultJText.setHorizontalAlignment(JTextField.RIGHT);
		resultJText.setDisabledTextColor(Color.RED);
		resultJText.setBorder(BorderFactory.createLoweredBevelBorder());

		// mother panel
		JPanel motherPanel = new JPanel();
		motherPanel.setLayout(new BoxLayout(motherPanel, BoxLayout.Y_AXIS));

		// text panel
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(0, 0));
		textPanel.add(resultJText);

		// number button panel
		JPanel numberButtonsPanel = new JPanel();
		numberButtonsPanel.setPreferredSize(new Dimension(160, 70));
		for (int i = 9; i >= 0; i--)
			numberButtonsPanel.add(numberButtons[i]);

		// function panel
		JPanel calculationButtonPanel = new JPanel();
		calculationButtonPanel.setPreferredSize(new Dimension());
		calculationButtonPanel.add(multiplyButton);
		calculationButtonPanel.add(divideButton);
		calculationButtonPanel.add(addButton);
		calculationButtonPanel.add(substractButton);

		JPanel functionButtonPanel = new JPanel();
		functionButtonPanel.setPreferredSize(new Dimension());
		functionButtonPanel.add(enterButton);
		functionButtonPanel.add(cButton);
		
		// add event
		NumberButtonsAction[] numberButtonActions = new NumberButtonsAction[10];
		for (int i = 9; i >= 0; i--) {
			numberButtonActions[i] = new NumberButtonsAction(numberButtons[i]);
			numberButtons[i].addActionListener(numberButtonActions[i]);
		}

		enterButton.addActionListener(new EnterButton());
		cButton.addActionListener(new CButton());
		multiplyButton.addActionListener(new MultiplyButton());
		divideButton.addActionListener(new DivideButton());
		addButton.addActionListener(new AddButton());
		substractButton.addActionListener(new SubstractButton());

		// create menu
		JMenuBar menuBar;
		JMenu menuAbout, menuFile;
		JMenuItem itemExit;

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 230, 21);

		menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);

		itemExit = new JMenuItem("Exit", KeyEvent.VK_E);
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == itemExit)
					System.exit(0);
			}
		});
		menuFile.add(itemExit);

		menuAbout = new JMenu("About");
		menuAbout.setMnemonic(KeyEvent.VK_A);
		menuAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(motherPanel,
						"Design by Trần Xuân Nam\nCopyright © 1995, 2015 Oracle and/or its affiliates. All rights reserved.",
						"About author", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuBar.add(menuFile);
		menuBar.add(menuAbout);

		// add to mother panel
		this.setJMenuBar(menuBar);
		motherPanel.add(textPanel);
		motherPanel.add(numberButtonsPanel);
		motherPanel.add(calculationButtonPanel);
		motherPanel.add(functionButtonPanel);
		setContentPane(motherPanel);
	}

	/**
	 * create the event
	 */
	private class NumberButtonsAction implements ActionListener {
		String c;

		public NumberButtonsAction(JButton a) {
			this.c = a.getText();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// clear all
			if (recentEnter) {
				resultJText.setText("0");
				tempNumbers1 = 0;
				tempNumbers1 = 0;
				function = -1;
				recentEnter = false;
			}

			if ((!resultJText.getText().equals("0")) && (!resultJText.getText().equals("0.0")))
				resultJText.setText(resultJText.getText() + c);
			else {
				resultJText.setText(c);
				// actionPerformed(e);
			}
		}
	}

	private class EnterButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				calculate();
				recentEnter = true;
				recentFunction = false;
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class CButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resultJText.setText("0");
			tempNumbers1 = 0;
			tempNumbers1 = 0;
			function = -1;
			recentEnter = false;
			recentFunction = false;
		}
	}

	private class MultiplyButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 0;
		}
	}

	private class DivideButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 1;
		}
	}

	private class AddButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 2;
		}
	}

	private class SubstractButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 3;
		}
	}

	/**
	 * calculate
	 */
	public void calculate() {
		tempNumbers2 = Double.parseDouble(resultJText.getText());
		if (function == 0)
			resultJText.setText(Double.toString(tempNumbers1 * tempNumbers2));
		else if (function == 1)
			resultJText.setText(Double.toString((tempNumbers1) / tempNumbers2));
		else if (function == 2)
			resultJText.setText(Double.toString(tempNumbers1 + tempNumbers2));
		else if (function == 3)
			resultJText.setText(Double.toString(tempNumbers1 - tempNumbers2));
		else
			resultJText.setText(String.valueOf(tempNumbers2));
		tempNumbers1 = Double.parseDouble(resultJText.getText());
		tempNumbers2 = 0;
	}
}
