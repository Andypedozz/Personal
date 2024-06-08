package controller;

import interfaces.MenuObserver;
import interfaces.View;
import model.menu.Model;

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
		this.view.getFrame().mainMenu();
	}
	
	@Override
	public void leaderboardScreen() {
		this.father.initLeaderboard();
	}

	@Override
	public void teamScreen() {
		this.father.initTeam();
	}

	@Override
	public void back() {
		this.model.getLogger().disconnect(1);
		this.model.getLogger().disconnect(0);
		this.father.initLogin();
	}
}
