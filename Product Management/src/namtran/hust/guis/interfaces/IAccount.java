package namtran.hust.guis.interfaces;

public interface IAccount {
	public void setUserID(String userID);

	public String getUserID();

	public void setPassword(String password);

	public String getPassword();

	public void setPermission(int permission);

	public int getPermission();
}
