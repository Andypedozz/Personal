package model.battle;

import model.menu.FileManager;
import interfaces.Match;
import interfaces.Model;
import model.menu.Lobby;
import model.menu.LoginManager;

public class ModelImpl implements Model{
	private FileManager fileManagerImpl;
	private LoginManager logger;
	private Lobby lobby;
	private Match match;
	private boolean saveEnabled;
	
	public void initAccountManager() {
		this.fileManagerImpl = FileManager.getInstance();
	}
	
	public FileManager getAccountManager() {
		return this.fileManagerImpl;
			
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
