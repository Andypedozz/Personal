package interfaces;

import controller.BattleController;
import model.Match;

public interface ViewObserver {
	void initLogin();
	void initTeam();
	void initLeaderboard();
	void initMainMenu();
	void initBattle(Match match);
	void disconnect(int select);
	LoginObserver getLoginObserver();
	TeamObserver getTeamObserver();
	BattleViewObserver getBattleObserver();
	MenuObserver getMenuObserver();
	LeaderboardObserver getLeadObserver();
}
