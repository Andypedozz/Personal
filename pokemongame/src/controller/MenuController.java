package controller;

import interfaces.MenuObserver;
import interfaces.Model;
import interfaces.View;

public class MenuController implements MenuObserver{
	private Model model;
	private View view;
	private Controller father;
	
	public MenuController(Model model, View view, Controller father) {
		this.model = model;
		this.view = view;
		this.father = father;
	}
	
	@Override
	public void initMenu() {
		// TODO Auto-generated method stub
		this.view.getFrame().mainMenu();
	}
	
	@Override
	public void leaderboardScreen() {
		// TODO Auto-generated method stub
		this.father.initLeaderboard();
	}

	@Override
	public void teamScreen() {
		// TODO Auto-generated method stub
		this.father.initTeam();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		this.model.getLogger().disconnect(1);
		this.model.getLogger().disconnect(0);
		this.father.initLogin();
	}
}
