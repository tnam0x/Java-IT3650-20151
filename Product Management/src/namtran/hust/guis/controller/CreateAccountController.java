package namtran.hust.guis.controller;

import namtran.hust.guis.model.Account;
import namtran.hust.guis.model.AccountList;

public class CreateAccountController {
	private AccountList accountList;
	private String userName;
	private String password;
	private int permission;
	private Account account;

	public CreateAccountController(String userName, String password, int permission) {
		this.userName = userName;
		this.password = password;
		this.permission = permission;
		accountList = new AccountList();
	}

	public boolean checkAccount() {
		accountList.check(userName, password);
		if (!accountList.isAccountHasExisted()) {
			updateAccount();
			accountList.addAccount(account);
		}
		return !accountList.isAccountHasExisted();
	}

	public void updateAccount() {
		account = new Account();
		account.setUserID(userName);
		account.setPassword(password);
		account.setPermission(permission);
	}
}
