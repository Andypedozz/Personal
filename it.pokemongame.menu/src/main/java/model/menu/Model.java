package model.menu;

import java.io.FileNotFoundException;

import model.battle.Match;

public class Model {
	private FileManager fileManager;
	private LoginManager logger;
	private Lobby lobby;
	private Match match;
	private boolean saveEnabled;
	
	public void initAccountManager() {
		this.fileManager = FileManager.getInstance();
	}
	
	public FileManager getAccountManager() {
		return this.fileManager;
			
	}	
	
	public void initLoginManager() {
		this.logger = LoginManager.getInstance();
		System.out.println("LoginManager inizializzato!");
	}
	
	public LoginManager getLogger() {
		return this.logger;	
	}

	
	public Lobby getLobby() {
		return this.lobby;
	}

	
	public void initLobby() {
		this.lobby = Lobby.getInstance();
	}
	
	
	public void setMatch(Match match) {
		
		this.match = match;
	}

	public boolean isSaveEnabled() {
		return this.saveEnabled;
	}
	
	public void setSave(boolean b) {
		this.saveEnabled = b;
	}

	public Match getMatch() {
		return this.match;
	}

	public void exitLobby() {
		this.lobby = null;
	}
}
