package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import interfaces.LoginObserver;

public class LoginForm extends JPanel{
	private LoginObserver observer;
	private int id;
	private BufferedImage bg;
	private TransparentTextField usernameField;
	private JPasswordField passwordField;
	private JLabel title, username, password, signUpLabel;
	private JButton login, signUp, disconnect;
	
	
	public LoginForm(int id, LoginObserver observer) {
		this.id = id;
		this.observer = observer;
		this.setSize(400,600);
		this.setLayout(null);
		this.setBackground(Color.black);
		// this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		try{
			if(id == 0)
				bg = ImageIO.read(this.getClass().getResource("/dialga_bg.jpg"));
			else
				bg = ImageIO.read(this.getClass().getResource("/palkia_bg.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Color color = Color.white;
		usernameField = new TransparentTextField(20);
		usernameField.setBackground(Color.DARK_GRAY);
		usernameField.setForeground(color);
		passwordField = new JPasswordField(20);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setForeground(color);
		title = new JLabel("LOGIN");
		title.setForeground(color);
		username = new JLabel("Username");
		username.setForeground(color);
		password = new JLabel("Password");
		password.setForeground(color);
		login = new JButton("Accedi");
		login.setBackground(Color.DARK_GRAY);
		login.setForeground(color);
		signUp = new JButton("Registrati");
		signUp.setBackground(Color.DARK_GRAY);
		signUp.setForeground(color);
		signUpLabel = new JLabel("Non hai un account?");
		signUpLabel.setForeground(color);
		disconnect = new JButton("Logout");
		disconnect.setBackground(Color.DARK_GRAY);
		disconnect.setForeground(color);
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
		this.login.addActionListener(e -> {
			String username = usernameField.getText();
			String password = passwordField.getText();
			observer.login(id,username,password);
		});
		
		// listener signUp button
		this.signUp.addActionListener(e -> {
			signUp();
		});
		
		// logout logic
		this.disconnect.addActionListener(e -> {
			observer.disconnect(id);
			enableButtons();
		});
	}
	
	public void loginFailed() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Account non trovato, cambia credenziali");
	}
	
	public void signUp() {
		SignUpForm sf = new SignUpForm();
		
		// sign up logic
		sf.confirm.addActionListener(e -> {
			String username = sf.usernameField.getText();
			String password = sf.passwordField.getText();
			String name = sf.nameField.getText();
			String gender = (String)sf.genderField.getSelectedItem();
			observer.register(username,password,name, gender);
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

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bg != null) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(),this);
        }
    }
	
}
