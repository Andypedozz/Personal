package controller;

import interfaces.BattleViewObserver;
import interfaces.LeaderboardObserver;
import interfaces.LoginObserver;
import interfaces.Match;
import interfaces.MenuObserver;
import interfaces.Model;
import interfaces.TeamObserver;
import interfaces.View;
import interfaces.ViewObserver;
import model.ModelImpl;
import view.ViewImpl;

public class Controller implements ViewObserver{
	// MODELLO E VISTA
	private Model model;
	private View view;
	
	// SOTTO-CONTROLLER
	private LoginController loginController;
	private TeamController teamController;
	private BattleController battleController;
	private MenuController menuController;
	private LeaderboardController leadController;

	// avvio applicazione
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
	
	// controller start
	public void start() {
		this.model = new ModelImpl("accountdata");
		this.view = new ViewImpl(this);
		this.initLogin();
	}
	
	@Override
	public void initLogin() {
		// TODO Auto-generated method stub
		this.loginController = new LoginController(model,view,this);
		this.loginController.initLogin();
	}

	@Override
	public void initTeam() {
		// TODO Auto-generated method stub
		this.teamController = new TeamController(model,view,this);
		this.teamController.initTeam();
	}

	@Override
	public void initBattle(Match match) {
		this.battleController = new BattleController(view, model);
		this.battleController.startBattle(match);
	}

	@Override
	public void disconnect(int select) {
		// TODO Auto-generated method stub
		this.loginController.disconnect(select);
	}

	@Override
	public LoginObserver getLoginObserver() {
		// TODO Auto-generated method stub
		return this.loginController;
	}

	@Override
	public TeamObserver getTeamObserver() {
		// TODO Auto-generated method stub
		return this.teamController;
	}

	@Override
	public BattleViewObserver getBattleObserver() {
		// TODO Auto-generated method stub
		return this.battleController;
	}

	@Override
	public void initLeaderboard() {
		// TODO Auto-generated method stub
		this.leadController = new LeaderboardController(model,view,this);
		this.leadController.initLeaderboard();
	}

	@Override
	public void initMainMenu() {
		// TODO Auto-generated method stub
		this.menuController = new MenuController(model,view,this);
		this.menuController.initMenu();
	}
	
	@Override
	public MenuObserver getMenuObserver() {
		// TODO Auto-generated method stub
		return this.menuController;
	}

	@Override
	public LeaderboardObserver getLeadObserver() {
		// TODO Auto-generated method stub
		return this.leadController;
	}

}
