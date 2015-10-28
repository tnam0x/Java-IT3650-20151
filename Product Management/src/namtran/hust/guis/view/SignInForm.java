package namtran.hust.guis.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import namtran.hust.guis.controller.Run;
import namtran.hust.guis.controller.SignInController;
import namtran.hust.guis.interfaces.ISignInForm;

public class SignInForm extends JFrame implements ISignInForm {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField tfPassword;

	public SignInForm() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Sign in");
		setSize(400, 200);
		setLocation(400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		setContentPane(contentPane);

		// mother panel
		JPanel motherPanel = new JPanel();
		motherPanel.setLocation(10, 11);
		motherPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.setSize(370, 149);
		motherPanel.setLayout(null);
		contentPane.add(motherPanel);

		// create label
		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setBounds(24, 11, 83, 27);
		lblUsername.setLabelFor(lblUsername);
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblUsername.setForeground(Color.BLACK);
		motherPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblPassword.setBounds(24, 49, 83, 28);
		motherPanel.add(lblPassword);

		// create text field
		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		tfUserName.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		tfUserName.setBounds(117, 10, 196, 30);
		tfUserName.setColumns(10);
		tfUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
					tfPassword.requestFocus();
			}
		});
		motherPanel.add(tfUserName);

		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		tfPassword.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		tfPassword.setBounds(117, 47, 196, 30);
		tfPassword.setColumns(10);
		tfPassword.setEchoChar('⊹');
		tfPassword.setActionCommand("Sign in");
		motherPanel.add(tfPassword);

		// create button
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setBounds(60, 97, 109, 30);
		// btnSignIn.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		btnSignIn.setActionCommand("Sign in");
		motherPanel.add(btnSignIn);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnCancel.setBounds(204, 97, 109, 30);
		// btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.add(btnCancel);

		// add event
		tfPassword.addActionListener(new EventHandler());
		btnSignIn.addActionListener(new EventHandler());
		btnCancel.addActionListener(new EventHandler());
	}

	// handler event
	private class EventHandler implements ActionListener {
		String s;

		@Override
		public void actionPerformed(ActionEvent e) {
			s = e.getActionCommand();

			// sign in
			if (s.equals("Sign in")) {
				// check textfield
				if (tfUserName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(SignInForm.this, "Username cannot be empty", "Invalid",
							JOptionPane.ERROR_MESSAGE);
					tfUserName.requestFocus();
					return;
				} else if (String.valueOf(tfPassword.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(SignInForm.this, "Passwrod cannot be empty", "Invalid",
							JOptionPane.ERROR_MESSAGE);
					tfPassword.requestFocus();
					return;
				}

				String userName = getUserNameOnSignInForm();
				String password = getPasswordOnSignInForm();
				SignInController signIn = new SignInController(userName, password);

				int check = signIn.checkSignIn();
				// sign in ok
				if (check == 1) {
					JOptionPane.showMessageDialog(SignInForm.this, "Sign in successfully", "Sign in",
							JOptionPane.INFORMATION_MESSAGE);
					tfUserName.setText("");
					tfPassword.setText("");
					Run run = new Run();
					run.signIn();
				}
				// username or password is wrong
				else if (check == 0)
					JOptionPane.showMessageDialog(SignInForm.this, "Username or password is invalid!",
							"Invalid account", JOptionPane.ERROR_MESSAGE);
				// no account
				else if (check == -1)
					JOptionPane.showMessageDialog(SignInForm.this,
							"No any account has registered yet, please create an account!", "Invalid account",
							JOptionPane.ERROR_MESSAGE);
			}
			// click button cancel
			else if (s.equals("Cancel"))
				System.exit(0);
		}
	}

	@Override
	public String getUserNameOnSignInForm() {
		String result = tfUserName.getText();
		tfUserName.requestFocus();
		return result;
	}

	@Override
	public String getPasswordOnSignInForm() {
		String result = String.valueOf(tfPassword.getPassword());
		return result;
	}
}
