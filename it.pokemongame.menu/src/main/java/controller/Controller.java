package controller;

import java.io.FileNotFoundException;

import interfaces.BattleViewObserver;
import interfaces.LeaderboardObserver;
import interfaces.LoginObserver;
import interfaces.Match;
import interfaces.Model;
import interfaces.MenuObserver;
import interfaces.TeamObserver;
import interfaces.View;
import interfaces.ViewObserver;
import model.battle.ModelImpl;
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
	
	// controller start
	public void start() {
		this.model = new ModelImpl();
		this.model.initAccountManager();
		try {
			this.model.getAccountManager().openFileDirectory(getClass().getResource("/accountdata").getPath());
			this.model.getAccountManager().readFromFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.model.initLoginManager();
		this.view = new ViewImpl(this);
		this.view.getFrame().firstMenu();
	}
	
	@Override
	public void initLogin() {
		this.model.setSave(true);
		this.loginController = new LoginController(model,view,this);
		this.loginController.initLogin();
	}

	@Override
	public void initTeam() {
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
		this.loginController.disconnect(select);
	}

	@Override
	public LoginObserver getLoginObserver() {
		return this.loginController;
	}

	@Override
	public TeamObserver getTeamObserver() {
		return this.teamController;
	}

	@Override
	public BattleViewObserver getBattleObserver() {
		return this.battleController;
	}

	@Override
	public void initLeaderboard() {
		this.leadController = new LeaderboardController(model,view,this);
		this.leadController.initLeaderboard();
	}

	@Override
	public void initMainMenu() {
		this.menuController = new MenuController(model,view,this);
		this.menuController.initMenu();
	}
	
	@Override
	public MenuObserver getMenuObserver() {
		return this.menuController;
	}

	@Override
	public LeaderboardObserver getLeadObserver() {
		return this.leadController;
	}

	@Override
	public void quickPlay() {
		this.model.setSave(false);
		this.initTeam();
	}

}
