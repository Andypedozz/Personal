package interfaces;

import model.menu.FileManager;
import model.menu.Lobby;
import model.menu.LoginManager;

public interface Model {
	FileManager getAccountManager();
	LoginManager getLoginManager();
	Lobby getLobby();
	void initLobby();
	void setMatch(Match match);
	Match getMatch();
	void initAccountManager();
	void initLoginManager();
	void setSave(boolean b);
	void exitLobby();
	boolean isSaveEnabled();
}
