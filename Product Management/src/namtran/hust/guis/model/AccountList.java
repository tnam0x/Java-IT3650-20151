package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import namtran.hust.guis.interfaces.IAccount;
import namtran.hust.guis.interfaces.IAccountList;

public class AccountList implements IAccountList {
	private ArrayList<IAccount> accountList;
	private IAccount account;
	private final int HAVE_ACCOUNT = 1;
	private final int NOT_HAVE_ACCOUNT = 0;
	private final int NO_ACCOUNT = -1;
	private int permission;

	public AccountList() {
		try (BufferedReader reader = new BufferedReader(new FileReader("src\\account list.txt"))) {
			String line;
			StringTokenizer readData;
			accountList = new ArrayList<IAccount>();

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
			System.out.println(e);
		}
	}

	// add account
	@Override
	public void addAccount(IAccount account) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("account list.txt", true), true)) {
			writer.println(account.getUserID() + " " + account.getPassword() + " " + account.getPermission());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// check username and password
	@Override
	public int check(String userName, String password) {
		int result = NOT_HAVE_ACCOUNT;
		if (!accountList.isEmpty())
			for (int i = 0; i < accountList.size(); i++) {
				if (userName.equals(accountList.get(i).getUserID()))
					if (password.equals(accountList.get(i).getPassword())) {
						result = HAVE_ACCOUNT;
						permission = accountList.get(i).getPermission();
						break;
					}
			}
		else
			result = NO_ACCOUNT;
		return result;
	}

	public int getPermission() {
		return permission;
	}
}
