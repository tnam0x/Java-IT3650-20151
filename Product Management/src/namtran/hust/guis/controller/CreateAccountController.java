package namtran.hust.guis.controller;

import namtran.hust.guis.model.Account;
import namtran.hust.guis.model.AccountList;

public class CreateAccountController {
	private AccountList accList;
	private String userName;
	private String password;
	private int permission;
	private Account account;

	public CreateAccountController(String userName, String password, int permission) {
		this.userName = userName;
		this.password = password;
		this.permission = permission;
		accList = new AccountList();
	}

	public boolean checkAccount() {
		accList.check(userName, password);
		if (!accList.isAccountHasExisted()) {
			updateAccount();
			accList.addAccount(account);
		}
		return !accList.isAccountHasExisted();
	}

	public void updateAccount() {
		account = new Account();
		account.setUserID(userName);
		account.setPassword(password);
		account.setPermission(permission);
	}
}
