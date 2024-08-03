package interfaces;

import java.util.List;

import model.menu.Account;

public interface LeaderboardObserver {
	void initLeaderboard();

	void back();

	List<Account> getAccounts();
}
