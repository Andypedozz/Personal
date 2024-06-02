package model.menu;

import java.io.FileNotFoundException;
import java.util.HashMap;

import interfaces.FileManager;
import model.menu.Account;
import model.menu.User;

public class LoginManager {
	private static LoginManager INSTANCE = null;
	private AccountManager fileManager;
	private boolean logged[];
	
	private LoginManager() {
		this.fileManager = AccountManager.getInstance();
		this.logged = new boolean[2];
	}
	
	public static LoginManager getInstance() {
		if(INSTANCE == null)
			INSTANCE = new LoginManager();
		return INSTANCE;
	}
	
	// metodo per loggare
	public int login(int select, String username, String password) {
		int result;
		boolean found = false;
		
		// creo l'account con solo le credenziali
		Account toLogin = new Account(username,password);
		
		if(this.fileManager.getDataList().contains(toLogin)) {
			while(!found) {
				for(Account a : this.fileManager.getDataList())
					if(a.equals(toLogin)) {
						found = true;
						toLogin = a;
					}
			}
			if(!toLogin.getState()) {
				toLogin.setState(true);
				this.fileManager.getUsedData().add(toLogin);
				System.out.println("Profilo "+(select+1)+" loggato come "+toLogin.getUsername());
				this.logged[select] = true;
				result = 0;
			}else {
				System.out.println("Account già utilizzato!");
				result = 1;
			}
		}else {
			System.out.println("Errore: Account non trovato");
			result = 2;
		}
		return result;
	}
	
	// metodo per registrarsi
	public void register(String username, String password, String name, String gender) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if(this.fileManager.getOpenedDirectory() == null || !this.fileManager.getOpenedDirectory().exists())
			throw new FileNotFoundException("Directory non impostata!");
		int newId;
		User user = new User(name,gender);
		if(this.fileManager.getDataList().size() > 0) {
			int lastId = this.fileManager.getDataList().get(this.fileManager.getDataList().size() - 1).getId();
			System.out.println("Last id: "+lastId);
			newId = lastId + 1;
		}else
			newId = 0;
		Account toAdd = new Account(username,password,user,newId);
		if(!this.fileManager.getDataList().contains(toAdd)) {
			this.fileManager.getDataList().add(toAdd);
			System.out.println("Nuovo account registrato correttamente");
			this.fileManager.writeNewFile(toAdd);
		}else
			System.out.println("Account già esistente!");
	}

	public void disconnect(int select) {
		this.fileManager.getDataList().get(select).setState(false);
		this.fileManager.getUsedData().remove(select);
		System.out.println("Account "+(select+1)+" disconnesso!");
		this.logged[select] = false;
	}

	public boolean ready() {
		// TODO Auto-generated method stub
		return this.logged[0] && this.logged[1];
	}

}