package model;

import java.io.FileNotFoundException;

public class Model {
	private AccountManager fileManager;
	private LoginManager logger;
	private Lobby lobby;
	private Match match;
	
	public Model(String filepath) {
		this.fileManager = AccountManager.getInstance();
		try {
			this.fileManager.openFileDirectory(filepath);
			this.fileManager.readFromFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.logger = LoginManager.getInstance();
		System.out.println("LoginManager inizializzato!");
	}
	
	public AccountManager getAccountManager() {
		// TODO Auto-generated method stub
		return this.fileManager;
			
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
		this.lobby = new Lobby();
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
