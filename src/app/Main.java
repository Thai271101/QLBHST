package app;

import java.awt.EventQueue;

import login.IDandPasswords;
import login.LoginPage;


public class Main {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDandPasswords idandPasswords = new IDandPasswords();
					
					LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

