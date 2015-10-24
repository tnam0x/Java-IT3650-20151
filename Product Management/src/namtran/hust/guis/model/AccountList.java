package namtran.hust.guis.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import namtran.hust.guis.interfaces.IAccount;
import namtran.hust.guis.interfaces.IAccountList;

public class AccountList implements IAccountList {
	private ArrayList<Account> accountList;
	private Account account;

	public AccountList() {
		try (BufferedReader reader = new BufferedReader(new FileReader("D:\\account.txt"))) {
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
					System.out.println(account);
					accountList.add(account);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void addAccount(IAccount iAccount) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("account list.txt", true))) {
			writer.write(iAccount.getUserID() + " " + iAccount.getPassword() + " " + iAccount.getPermission());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int check(String userName, String password) {
		int result = 0;
		if (!accountList.isEmpty())
			for (int i = 0; i < accountList.size(); i++) {
				if (userName.equals(accountList.get(i).getUserID()))
					if (password.equals(accountList.get(i).getPassword())) {
						result = 1;
						break;
					}
			}
		else
			result = -1;
		return result;
	}

}
