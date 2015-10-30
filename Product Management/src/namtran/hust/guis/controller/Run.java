package namtran.hust.guis.controller;

import namtran.hust.guis.view.MainWindow;
import namtran.hust.guis.view.SignInForm;

public class Run {
	private static SignInForm signInForm;
	private static MainWindow mainWindow;

	public static void main(String[] args) {
		signInForm = new SignInForm();
		signInForm.setVisible(true);
	}

	// sign in successfully
	public void signInSuccess() {
		signInForm.setVisible(false);
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

	// click sign handler
	public void signOutHandler() {
		mainWindow.setVisible(false);
		signInForm = new SignInForm();
		signInForm.setVisible(true);
	}

	// update table
	public void updateTable() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
}
