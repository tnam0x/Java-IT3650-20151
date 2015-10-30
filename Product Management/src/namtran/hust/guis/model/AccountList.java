package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class AccountList {
	private ArrayList<Account> accountList;
	private Account account;
	private final int EXIST_ACCOUNT = 1;
	private final int NOT_EXIST_ACCOUNT = 0;
	private final int NO_ANY_ACCOUNT = -1;
	private boolean accountHasExisted;
	private int permission;

	public AccountList() {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("account list.txt");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			String line;
			StringTokenizer readData;
			accountList = new ArrayList<Account>();

			while ((line = reader.readLine()) != null) {
				readData = new StringTokenizer(line, " ");

				while (readData.hasMoreTokens()) {
					account = new Account();

					account.setUserID(readData.nextToken());
					account.setPassword(readData.nextToken());
					account.setPermission(Integer.parseInt(readData.nextToken()));
					accountList.add(account);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), e, "File error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

	// add account
	public void addAccount(Account account) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("src\\account list.txt", true), true)) {
			writer.println(account.getUserID() + " " + account.getPassword() + " " + account.getPermission());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), e, "File error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check username and password
	public int check(String userName, String password) {
		int result = NOT_EXIST_ACCOUNT;

		if (!accountList.isEmpty())
			for (int i = 0; i < accountList.size(); i++) {
				Account account = accountList.get(i);

				if (userName.equals(account.getUserID())) {
					accountHasExisted = true;

					if (password.equals(account.getPassword())) {
						result = EXIST_ACCOUNT;
						permission = account.getPermission();
						break;
					}
				}
			}
		else
			result = NO_ANY_ACCOUNT;
		return result;
	}

	public int getPermission() {
		return permission;
	}

	public boolean isAccountHasExisted() {
		return accountHasExisted;
	}
}
