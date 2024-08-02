package controller;

import java.util.LinkedList;
import java.util.List;
import interfaces.LeaderboardObserver;
import interfaces.View;
import model.menu.Account;
import interfaces.Model;

public class LeaderboardController implements LeaderboardObserver {
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
		this.view.getFrame().leaderboard();
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> accounts = new LinkedList<>();
		this.model.getAccountManager().getDataMap().forEach((s, a) -> {
			accounts.add(model.getAccountManager().getDataMap().get(s));
		});
		return accounts;
	}

	public void back() {
		this.father.initMainMenu();
	}
}
