package namtran.hust.guis.controller;

import namtran.hust.guis.model.AccountList;

public class SignInController {
	private static String userName;
	private String password;
	private AccountList accountList;
	private int result;
	private static int currentAccountPermission;

	public SignInController() {

	}

	public SignInController(String user, String password) {
		userName = user;
		this.password = password;
	}

	// check account and password
	public int checkSignIn() {
		accountList = new AccountList();
		result = accountList.check(userName, password);
		currentAccountPermission = accountList.getPermission();
		return result;
	}

	public int getCurrentAccountPermission() {
		return currentAccountPermission;
	}

	public String getUserName() {
		return userName;
	}
}
