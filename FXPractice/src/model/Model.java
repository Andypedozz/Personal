package model;

public class Model{
	private Logger logger;
	private AccountManager accManager;

	public void start() {
		this.accManager = new AccountManager();
		this.accManager.openFileDirectory("src/accountdata");
		this.initLogger();
		this.accManager.readFromFile();
	}
	
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return this.logger;
	}

	
	public AccountManager getAccountManager() {
		// TODO Auto-generated method stub
		return this.accManager;
	}
	
	
	public void initLogger() {
		// TODO Auto-generated method stub
		this.logger = new Logger(this.accManager);
	}
}
