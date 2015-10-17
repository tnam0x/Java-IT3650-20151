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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Font;

public class SimpleCalculate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField resultJText;
	private JPanel motherPanel;
	private double tempNumbers1 = 0;
	private double tempNumbers2 = 0;
	private byte function = -1;
	private String piOrString;
	private boolean recentEnter, recentFunction, recentSpecialButton;

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
		// create main frame
		setTitle("Calculator");
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}
		setSize(230, 330);
		setResizable(false);
		setLocationByPlatform(true);
		setVisible(true);

		// create number buttons
		JButton[] numberButtons = new JButton[10];
		for (int i = 9; i >= 0; i--)
			numberButtons[i] = new JButton(Integer.toString(i));

		JButton enterButton = new JButton("Enter");
		enterButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton cButton = new JButton("C");
		cButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton signalButton = new JButton("±");
		signalButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton squareButton = new JButton("x²");
		squareButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton squareRootButton = new JButton("√");
		squareRootButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton piButton = new JButton("π");
		piButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton commaButton = new JButton(".");
		commaButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

		JButton multiplyButton = new JButton("x");
		multiplyButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton divideButton = new JButton("÷");
		divideButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton addButton = new JButton("+");
		addButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton substractButton = new JButton("-");
		substractButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

		// create text field to display
		resultJText = new JTextField("0");
		resultJText.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		resultJText.setBounds(22, 11, 180, 25);
		resultJText.setPreferredSize(new Dimension(180, 25));
		resultJText.setBackground(Color.WHITE);
		resultJText.setEnabled(false);
		resultJText.setHorizontalAlignment(JTextField.RIGHT);
		resultJText.setDisabledTextColor(Color.RED);
		resultJText.setBorder(BorderFactory.createLoweredBevelBorder());

		// mother panel
		motherPanel = new JPanel();

		// text panel
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 0, 224, 52);
		textPanel.setPreferredSize(new Dimension(0, 0));
		textPanel.setLayout(null);
		textPanel.add(resultJText);

		// number button panel
		JPanel numberButtonsPanel = new JPanel();
		numberButtonsPanel.setBounds(0, 52, 224, 122);
		numberButtonsPanel.setPreferredSize(new Dimension(160, 70));
		for (int i = 9; i >= 0; i--)
			numberButtonsPanel.add(numberButtons[i]);
		numberButtonsPanel.add(signalButton);
		numberButtonsPanel.add(squareButton);
		numberButtonsPanel.add(squareRootButton);
		numberButtonsPanel.add(piButton);
		numberButtonsPanel.add(commaButton);

		// calculation panel
		JPanel calculationButtonPanel = new JPanel();
		calculationButtonPanel.setBounds(0, 174, 224, 43);
		calculationButtonPanel.setPreferredSize(new Dimension());
		calculationButtonPanel.add(multiplyButton);
		calculationButtonPanel.add(divideButton);
		calculationButtonPanel.add(addButton);
		calculationButtonPanel.add(substractButton);

		// function panel
		JPanel functionButtonPanel = new JPanel();
		functionButtonPanel.setBounds(0, 216, 224, 62);
		functionButtonPanel.setPreferredSize(new Dimension());
		functionButtonPanel.add(enterButton);
		functionButtonPanel.add(cButton);

		// add event
		NumberButtonsAction[] numberButtonActions = new NumberButtonsAction[11];
		for (int i = 9; i >= 0; i--) {
			numberButtonActions[i] = new NumberButtonsAction(numberButtons[i]);
			numberButtons[i].addActionListener(numberButtonActions[i]);
		}
		numberButtonActions[10] = new NumberButtonsAction(piButton);
		piButton.addActionListener(numberButtonActions[10]);

		signalButton.addActionListener(new SignalButton());
		squareButton.addActionListener(new SquareButton());
		squareRootButton.addActionListener(new SquareRootButton());
		commaButton.addActionListener(new CommaButton());
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
		menuFile.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		menuFile.setMnemonic(KeyEvent.VK_F);
		itemExit = new JMenuItem("Exit", KeyEvent.VK_E);
		itemExit.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == itemExit)
					System.exit(0);
			}
		});
		menuFile.add(itemExit);

		menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		menuAbout.setMnemonic(KeyEvent.VK_A);
		menuAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(motherPanel,
						"Designed by Trần Xuân Nam\nCopyright © 1995, 2015 Oracle and/or its affiliates. All rights reserved.",
						"About author", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// add menu to menu panel
		menuBar.add(menuFile);
		menuBar.add(menuAbout);

		// add to mother panel
		this.setJMenuBar(menuBar);
		motherPanel.setLayout(null);
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

			String s = resultJText.getText();
			if ((!s.equals("0")) && !s.equals("∞") && !recentEnter && !recentSpecialButton)
				resultJText.setText(s + c);
			else {
				resultJText.setText(c);
				recentSpecialButton = false;
			}
		}
	}

	private class SignalButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = resultJText.getText();
			if (!s.equals("∞")) {
				if (s.equals("0") || s.equals("0.0"))
					resultJText.setText("-");
				else if (s.charAt(0) == '-') {
					s = s.substring(1, s.length());
					resultJText.setText(s);
				} else
					resultJText.setText("-" + s);
			}
		}
	}

	private class CommaButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = resultJText.getText();
			boolean isValid = true;
			if (!s.equals("∞") && !s.contains("π")) {
				for (int i = 0; i < s.length(); i++)
					if (s.charAt(i) == '.') {
						isValid = false;
						break;
					}
				if (isValid) {
					if (s.equals("0"))
						resultJText.setText("0.");
					else
						resultJText.setText(s + ".");
				}
			}
		}
	}

	private class SquareButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = resultJText.getText();
			if (!s.equals("∞") && !s.equals("-")) {
				if (!s.contains("π")) {
					double d = Double.parseDouble(s) * Double.parseDouble(s);
					resultJText.setText(String.valueOf(d));
					recentSpecialButton = true;
				} else if (s.equals("π") || s.equals("-π")) {
					resultJText.setText(String.valueOf(Math.PI * Math.PI));
					recentSpecialButton = true;
				} else
					JOptionPane.showMessageDialog(motherPanel, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else
				JOptionPane.showMessageDialog(motherPanel, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class SquareRootButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = resultJText.getText();
			if (!s.equals("∞") && s.charAt(0) != '-' && !s.contains("π")) {
				double d = Math.sqrt(Double.parseDouble(s));
				resultJText.setText(String.valueOf(d));
				recentSpecialButton = true;
			} else if (s.equals("π"))
				resultJText.setText(String.valueOf(Math.sqrt(Math.PI)));
			else
				JOptionPane.showMessageDialog(motherPanel, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class EnterButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (checkTextField()) {
				if (!piOrString.equals("-")) {
					calculate();
					recentEnter = true;
					recentFunction = false;
				} else {
					JOptionPane.showMessageDialog(motherPanel, "Please enter a number!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
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
			checkTextField();
			if (!piOrString.equals("∞")) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(piOrString);
					resultJText.setText("0");
					recentEnter = false;
				} else {
					resultJText.setText("0");
				}
				recentFunction = true;
			}
			function = 0;
		}
	}

	private class DivideButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkTextField();
			if (!resultJText.getText().equals("∞")) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(piOrString);
					resultJText.setText("0");
					recentEnter = false;
				} else {
					resultJText.setText("0");
				}
				recentFunction = true;
			}
			function = 1;
		}
	}

	private class AddButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkTextField();
			if (!piOrString.equals("∞")) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(piOrString);
					resultJText.setText("0");
					recentEnter = false;
				} else {
					resultJText.setText("0");
				}
				recentFunction = true;
			}
			function = 2;
		}
	}

	private class SubstractButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkTextField();
			if (!piOrString.equals("∞")) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(piOrString);
					resultJText.setText("0");
					recentEnter = false;
				} else {
					resultJText.setText("0");
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
		tempNumbers2 = Double.parseDouble(piOrString);
		if (function == 0)
			resultJText.setText(Double.toString(tempNumbers1 * tempNumbers2));

		else if (function == 1) {
			if (tempNumbers2 != 0)
				resultJText.setText(Double.toString((tempNumbers1) / tempNumbers2));
			else
				resultJText.setText("∞");
		}

		else if (function == 2)
			resultJText.setText(Double.toString(tempNumbers1 + tempNumbers2));

		else if (function == 3)
			resultJText.setText(Double.toString(tempNumbers1 - tempNumbers2));

		else
			resultJText.setText(String.valueOf(tempNumbers2));

		if (!resultJText.getText().equals("∞"))
			tempNumbers1 = Double.parseDouble(resultJText.getText());
		else
			tempNumbers1 = 0;
		tempNumbers2 = 0;
	}

	public boolean checkTextField() {
		piOrString = resultJText.getText();
		boolean isValid = false;
		if (piOrString.contains("π") && piOrString.length() == 1) {
			piOrString = Double.toString(Math.PI);
			isValid = true;
		} else if (piOrString.contains("-π") && piOrString.length() == 2) {
			piOrString = Double.toString(-Math.PI);
			isValid = true;
		} else if (!piOrString.contains("π"))
			isValid = true;
		else
			JOptionPane.showMessageDialog(motherPanel, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
		return isValid;
	}
}
