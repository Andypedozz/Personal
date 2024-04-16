package interfaces;

import model.AccountManager2;

public interface Model {
	AccountManager2 getAccountManager();
	Logger getLogger();
	Lobby getLobby();
	void initLobby();
	void exitLobby();
	void setMatch(Match match);
	Match getMatch();
}
