package view;

import java.awt.GridLayout;
import javax.swing.*;
import interfaces.LoginObserver;

public class LoginPanel extends JPanel{
	private LoginForm2 loginForms[];
	
	public LoginPanel(LoginObserver observer) {
		// init settings
		this.setSize(800,600);
		this.setLayout(new GridLayout(1,2));
		
		this.loginForms = new LoginForm2[2];
		this.loginForms[0] = new LoginForm2(0,observer);
		this.loginForms[1] = new LoginForm2(1,observer);
		this.add(loginForms[0]);
		this.add(loginForms[1]);
		this.setVisible(true);
	}
	
	public void initListeners() {
		this.loginForms[0].initListeners();
		this.loginForms[1].initListeners();
	}
	
	public void accountNotFound() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Account non trovato, cambia credenziali");
	}
	
	public void alreadyInUse() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Account già in uso");
	}
	
	public void signUpFailed() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame,"Campi invalidi!");
	}
	
	public void obscurePanel(int select) {
		this.loginForms[select].disableButtons();
	}
}
