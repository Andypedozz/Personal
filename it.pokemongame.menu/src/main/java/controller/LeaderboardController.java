package controller;

import java.util.List;
import interfaces.LeaderboardObserver;
import interfaces.View;
import model.menu.Account;
import model.menu.Model;

public class LeaderboardController implements LeaderboardObserver{
	private Model model;
	private View view;
	private Controller father;
	
	public LeaderboardController(Model model, View view, Controller father) {
		this.model = model;
		this.view = view;
		this.father = father;
	}
	
	@Override
	public void initLeaderboard() {
		// TODO Auto-generated method stub
		this.view.getFrame().leaderboard();
		List<Account> accounts = List.copyOf(this.model.getAccountManager().getDataList());
		this.view.getFrame().getLeaderboardPanel().loadRecords(accounts);
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		this.father.initMainMenu();
	}
}
