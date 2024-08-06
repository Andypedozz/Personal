package controller;

import java.io.FileNotFoundException;

import interfaces.LoginObserver;
import interfaces.View;
import interfaces.Model;

public class LoginController implements LoginObserver{
	private Controller father;
	private Model model;
	private View view;
	
	public LoginController(Model model, View view, Controller father) {
		this.father = father;
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void initLogin() {
		this.view.getFrame().loginMenu();
	}
	
	@Override
	public void register(String username, String password, String name, String gender) {
		if(!username.isBlank() && !password.isBlank() && !name.isBlank() && !gender.isBlank()) {
			try {
				boolean result = this.model.getLoginManager().register(username, password);
				if(!result) {
					this.view.getFrame().getLoginPanel().accountAlreadyRegistered();
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}else {
			this.view.getFrame().getLoginPanel().signUpFailed();
		}
	}

	@Override
	public void login(int select, String username, String password) {
		int logged = this.model.getLoginManager().login(username, password, select);
		switch(logged) {
		case 0:
			if(this.model.getLoginManager().ready())
				this.father.initMainMenu();
			else
				this.view.getFrame().getLoginPanel().obscurePanel(select);
			break;
		case 1:
			this.view.getFrame().getLoginPanel().accountNotFound();
			break;
		case 3:
			this.view.getFrame().getLoginPanel().alreadyInUse();
			break;
		}
	}

	@Override
	public void disconnect(int select) {
		this.model.getLoginManager().disconnect(select);
	}
}
