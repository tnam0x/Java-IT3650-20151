package namtran.hust.guis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import namtran.hust.guis.model.AccountList;

public class SignInForm extends JFrame implements ISignInForm {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUserName;
	private JTextField tfPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInForm frame = new SignInForm();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	public SignInForm() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sign in");
		setSize(400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		setContentPane(contentPane);

		JPanel motherPanel = new JPanel();
		motherPanel.setLocation(10, 11);
		motherPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.setSize(370, 149);
		contentPane.add(motherPanel);
		motherPanel.setLayout(null);

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

		tfUserName = new JTextField();
		tfUserName.setForeground(Color.RED);
		tfUserName.setBounds(117, 10, 196, 30);
		tfUserName.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		tfUserName.setColumns(10);
		motherPanel.add(tfUserName);

		tfPassword = new JTextField();
		tfPassword.setForeground(Color.RED);
		tfPassword.setBounds(117, 47, 196, 30);
		tfPassword.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		tfPassword.setColumns(10);
		motherPanel.add(tfPassword);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setBounds(60, 97, 109, 30);
		btnSignIn.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.add(btnSignIn);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnCancel.setBounds(204, 97, 109, 30);
		btnCancel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.add(btnCancel);

		btnSignIn.addActionListener(new EventHandler());
		btnCancel.addActionListener(new EventHandler());
	}

	private class EventHandler implements ActionListener {
		String userName = getUserNameOnSignInForm();
		String password = getPasswordOnSignInForm();
		String s;
		AccountList accList;

		@Override
		public void actionPerformed(ActionEvent e) {
			s = e.getActionCommand();
			if (s.equals("Sign in")) {
				accList = new AccountList();
				
				int check = accList.check(userName, password);
				if (check == 1)
					JOptionPane.showMessageDialog(SignInForm.this, "Sign in successfully",
							"Sign in", JOptionPane.INFORMATION_MESSAGE);
				if (check == 0)
					JOptionPane.showMessageDialog(SignInForm.this, "Username or password is invalid!",
							"Invalid account", JOptionPane.ERROR_MESSAGE);
				if(check == -1)
					JOptionPane.showMessageDialog(SignInForm.this, "No any account has registered yet, please create an account!",
							"Invalid account", JOptionPane.ERROR_MESSAGE);
			}
			if (s.equals("Cancel")) {
				System.exit(0);
			}
		}
	}

	@Override
	public String getUserNameOnSignInForm() {
		return tfUserName.getText();
	}

	@Override
	public String getPasswordOnSignInForm() {
		return tfPassword.getText();
	}
}
