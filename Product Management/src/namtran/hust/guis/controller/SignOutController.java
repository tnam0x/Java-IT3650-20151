package namtran.hust.guis.controller;

import namtran.hust.guis.view.MainWindow;
import namtran.hust.guis.view.SignInForm;

public class SignOutController {
	private SignInForm signInForm;
	private MainWindow mainWindow;

	public void signOut(SignInForm signInForm, MainWindow mainWindow) {
		this.signInForm = signInForm;
		this.mainWindow = mainWindow;

		this.signInForm.setVisible(true);
		this.mainWindow.setVisible(false);
	}
}
