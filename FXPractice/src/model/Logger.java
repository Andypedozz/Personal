package model;

import java.util.HashMap;

public class Logger {
	private AccountManager fileManager;
	private boolean logged;
	
	public Logger(AccountManager fileManager) {
		this.fileManager = fileManager;
	}
	
	// metodo per loggare
	public LOGIN_EXIT login(String username, String password) {
		LOGIN_EXIT result;
		boolean found = false;
		
		// creo l'account con solo le credenziali
		if(!username.isBlank() && !password.isBlank()) {
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
					System.out.println("Profilo  loggato come "+toLogin.getUsername());
					this.logged = true;
					result = LOGIN_EXIT.LOGGED;
				}else {
					System.out.println("Account già utilizzato!");
					result = LOGIN_EXIT.ALREADY_LOGGED;
				}
			}else {
				System.out.println("Errore: Account non trovato");
				result = LOGIN_EXIT.NOT_FOUND;
			}
		}else
			result = LOGIN_EXIT.NULL_CREDENTIALS;
		return result;
	}
	
	// metodo per registrarsi
	public void register(String username, String password, String name, String gender, int age, double weight, double height) {
		// TODO Auto-generated method stub
		int newId;
		User user = new User(name,gender,age,weight,height);
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
			this.fileManager.writeNewFile(toAdd);			this.fileManager.readFromFile();
		}else
			System.out.println("Account già esistente!");
	}

	public void disconnect() {
		this.fileManager.getUsedData().get(0).setState(false);
		this.fileManager.getUsedData().remove(0);
		System.out.println("Account disconnesso!");
		this.logged = false;
	}
}
