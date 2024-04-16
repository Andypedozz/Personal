package controller;

import interfaces.LoginObserver;
import interfaces.Model;
import interfaces.View;

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
		// TODO Auto-generated method stub
		if(!username.isBlank() && !password.isBlank() && !name.isBlank() && !gender.isBlank())
			this.model.getLogger().register(username, password, name, gender);
		else
			this.view.getFrame().getLoginPanel().signUpFailed();
	}

	@Override
	public void login(int select, String username, String password) {
		// TODO Auto-generated method stub
		int logged = this.model.getLogger().login(select, username, password);
		switch(logged) {
		case 0:
			if(this.model.getLogger().ready())
				this.father.initMainMenu();
			else
				this.view.getFrame().getLoginPanel().obscurePanel(select);
			break;
		case 1:
			this.view.getFrame().getLoginPanel().alreadyInUse();
			break;
		case 2:
			this.view.getFrame().getLoginPanel().accountNotFound();
		}
	}

	@Override
	public void disconnect(int select) {
		// TODO Auto-generated method stub
		this.model.getLogger().disconnect(select);
	}
}
