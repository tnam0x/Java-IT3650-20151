package namtran.hust.guis.model;

import namtran.hust.guis.interfaces.IAccount;

public class Account implements IAccount {
	private String userID, password;
	private int permission;

	@Override
	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String getUserID() {
		return this.userID;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public int getPermission() {
		return this.permission;
	}

}
