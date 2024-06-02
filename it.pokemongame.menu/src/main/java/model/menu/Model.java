package model.menu;

import java.io.FileNotFoundException;

import model.battle.Match;

public class Model {
	private AccountManager fileManager;
	private LoginManager logger;
	private Lobby lobby;
	private Match match;
	
	public void initAccountManager(String filepath) {
		this.fileManager = AccountManager.getInstance();
		try {
			this.fileManager.openFileDirectory(filepath);
			this.fileManager.readFromFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public AccountManager getAccountManager() {
		// TODO Auto-generated method stub
		return this.fileManager;
			
	}	
	
	public void initLoginManager() {
		this.logger = LoginManager.getInstance();
		System.out.println("LoginManager inizializzato!");
	}
	
	public LoginManager getLogger() {
		// TODO Auto-generated method stub
		return this.logger;	
	}

	
	public Lobby getLobby() {
		// TODO Auto-generated method stub
		return this.lobby;
	}

	
	public void initLobby() {
		// TODO Auto-generated method stub
		this.lobby = Lobby.getInstance();
	}
	
	
	public void setMatch(Match match) {
		
		this.match = match;
	}
	
	
	public Match getMatch() {
		return this.match;
	}

	
	public void exitLobby() {
		// TODO Auto-generated method stub
		this.lobby = null;
	}
}
