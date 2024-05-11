package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import interfaces.LoginObserver;
import view.SignUpForm;

public class LoginForm extends JPanel{
	private LoginObserver observer;
	private int id;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel title, username, password, signUpLabel;
	private JButton login, signUp, disconnect;
	
	
	public LoginForm(int id, LoginObserver observer) {
		this.id = id;
		this.observer = observer;
		this.setSize(400,600);
		this.setLayout(null);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		title = new JLabel("LOGIN");
		username = new JLabel("Username");
		password = new JLabel("Password");
		login = new JButton("Accedi");
		signUp = new JButton("Registrati");
		signUpLabel = new JLabel("Non hai un account?");
		disconnect = new JButton("Logout");
		disconnect.setEnabled(false);
		
		title.setBounds(180,100,100,30);
		usernameField.setBounds(100,170,200,30);
		passwordField.setBounds(100,240,200,30);
		username.setBounds(30,170,100,30);
		password.setBounds(30,240,100,30);
		login.setBounds(160,300,80,30);
		signUp.setBounds(30,510,100,30);
		signUpLabel.setBounds(10,470,150,30);
		disconnect.setBounds(270,510,100,30);
		
		this.add(title);
		this.add(usernameField);
		this.add(passwordField);
		this.add(username);
		this.add(password);
		this.add(login);
		this.add(signUp);
		this.add(signUpLabel);
		this.add(disconnect);
	}
	
	public void initListeners() {
	// listener login button
		this.login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				observer.login(id,username,password);
			}	
		});
		
		// listener signUp button
		ActionListener s = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signUp();
			}
		};
		signUp.addActionListener(s);
		
		// logout logic
		this.disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.disconnect(id);
				enableButtons();
			}
			
		});

	}
	
	public void loginFailed() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Account non trovato, cambia credenziali");
	}
	
	public void signUp() {
		SignUpForm sf = new SignUpForm();
		
		// sign up logic
		sf.confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = sf.usernameField.getText();
				String password = sf.passwordField.getText();
				String name = sf.nameField.getText();
				String gender = (String)sf.genderField.getSelectedItem();
				observer.register(username,password,name, gender);
			}
		});
	}
	
	public void disableButtons() {
		this.usernameField.setEnabled(false);
		this.passwordField.setEnabled(false);
		this.signUp.setEnabled(false);
		this.login.setEnabled(false);
		this.disconnect.setEnabled(true);
	}
	
	public void enableButtons() {
		this.usernameField.setEnabled(true);
		this.usernameField.setText("");
		this.passwordField.setEnabled(true);
		this.passwordField.setText("");
		this.signUp.setEnabled(true);
		this.login.setEnabled(true);
		this.disconnect.setEnabled(false);
	}
	
}
