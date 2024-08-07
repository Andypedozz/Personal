package interfaces;

public interface ViewObserver {
	void initLogin();
	void initTeam();
	void initLeaderboard();
	void initMainMenu();
	void initBattle(Match match);
	void quickPlay();
	void disconnect(int select);
	LoginObserver getLoginObserver();
	TeamObserver getTeamObserver();
	BattleViewObserver getBattleObserver();
	MenuObserver getMenuObserver();
	LeaderboardObserver getLeadObserver();
}
