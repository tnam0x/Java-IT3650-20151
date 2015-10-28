package namtran.hust.guis.controller;

import namtran.hust.guis.model.AccountList;

public class SignInController {
	private String userName;
	private String password;
	private AccountList accList;
	private int result;
	private static int currentAccountPermission;

	public SignInController() {

	}

	public SignInController(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// check account and password
	public int checkSignIn() {
		accList = new AccountList();
		result = accList.check(userName, password);
		currentAccountPermission = accList.getPermission();
		return result;
	}

	public int getCurrentAccountPermission() {
		return currentAccountPermission;
	}
}
