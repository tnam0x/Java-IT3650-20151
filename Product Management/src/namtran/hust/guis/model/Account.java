package namtran.hust.guis.model;

public class Account {
	private String userID, password;
	private int permission;

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getPermission() {
		return this.permission;
	}

	public String toString() {
		return userID + " " + password + " " + permission;

	}

}
