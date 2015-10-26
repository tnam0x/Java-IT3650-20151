package namtran.hust.guis.controller;

import namtran.hust.guis.view.MainWindow;
import namtran.hust.guis.view.SignInForm;

public class Run {
	private static SignInForm signInForm;
	private static MainWindow mainWindow;

	public static void main(String[] args) {
		signInForm = new SignInForm();
		signInForm.setVisible(true);

		mainWindow = new MainWindow();
		mainWindow.setVisible(false);
	}
	
	// sign in successfully
	public void signIn() {
		signInForm.setVisible(false);
		mainWindow.setVisible(true);
	}
	
	// click sign handler
	public void signOut() {
		SignOutController sOC = new SignOutController();
		sOC.signOut(signInForm, mainWindow);
	}
}
