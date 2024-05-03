package model;

import interfaces.AccountManager;
import interfaces.Lobby;
import interfaces.Logger;
import interfaces.Match;
import interfaces.Model;
import interfaces.PokemonLoader;

public class ModelImpl implements Model{
	private AccountManager2 fileManager;
	private Logger logger;
	private Lobby lobby;
	private Match match;
	
	public ModelImpl(String filepath) {
		this.fileManager = AccountManager2.getInstance();
		this.fileManager.openFileDirectory(filepath);
		this.fileManager.readFromFile();
		this.logger = LoggerImpl.getInstance();
	}
	
	@Override
	public AccountManager2 getAccountManager() {
		// TODO Auto-generated method stub
		return this.fileManager;
			
	}
	
	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return this.logger;
			
	}

	@Override
	public Lobby getLobby() {
		// TODO Auto-generated method stub
		return this.lobby;
	}

	@Override
	public void initLobby() {
		// TODO Auto-generated method stub
		this.lobby = new LobbyImpl();
	}
	
	@Override
	public void setMatch(Match match) {
		
		this.match = match;
	}
	
	@Override
	public Match getMatch() {
		return this.match;
	}

	@Override
	public void exitLobby() {
		// TODO Auto-generated method stub
		this.lobby = null;
	}
}
