
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import interfaces.Account;
import interfaces.AccountManager;
import interfaces.User;

public class AccountManagerImpl implements AccountManager{
	private String filepath;
	private List<Account> accountList;
	private Account account[];
	private File fileAccount1;
	private File fileAccount2;
	
	public AccountManagerImpl(String filepath) {
		this.filepath = filepath;
		this.account = new Account[2];
	}
	
	// metodo per caricare gli account
	@Override
	public void loadAccounts() {
		File credFile = new File(this.filepath);	// opening directory
		File fileList[] = credFile.listFiles();		// opening all subfiles
		List<Account> accounts = new LinkedList<Account>();
		int lastId = 0, accountsLoaded = 0;
		
		System.out.println("Apertura cartella...");
		System.out.println("Apertura sottocartelle...");
		if(fileList != null) {
			try {
				for(File f : fileList) {
					Scanner scan = new Scanner(f);
					lastId = Integer.valueOf(f.getName());
					System.out.println("Caricamento dati account...");
					while(scan.hasNextLine()) {
						String username = scan.nextLine();
						String password = scan.nextLine();
						String name = scan.nextLine();
						String gender = scan.nextLine();
						int matches = Integer.parseInt(scan.nextLine());
						int wins = Integer.parseInt(scan.nextLine());
						int losses = Integer.parseInt(scan.nextLine());
						User user = new UserImpl(name,gender,matches,wins,losses);
						Account account = new AccountImpl(username,password,user,lastId);
						accounts.add(account);
						accountsLoaded++;
					}
					scan.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
		}
		System.out.println(accountsLoaded+" account caricati correttamente!");
		this.accountList = accounts;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return this.accountList;
	}

	@Override
	public Account getAccount(int select) {
		// TODO Auto-generated method stub
		return this.account[select];
	}

	// metodo per aggiornare i dati degli account in uso su file
	@Override
	public void updateAccount(int select) {
		File accountFile = new File(filepath);
		File fileList[] = accountFile.listFiles();
		for(File f : fileList) {
			if(this.fileAccount1.equals(f)) {
				f.delete();
				File updated = new File(this.fileAccount1.getName());
				try {
					FileWriter myWriter = new FileWriter(this.fileAccount1.getName());
					myWriter.write(this.account[select].getUsername()+"\n"+
							account[select].getPassword()+"\n"+
							account[select].getUser().getName()+"\n"+
							account[select].getUser().getGender()+"\n"+
							account[select].getUser().getMatches()+"\n"+
							account[select].getUser().getWins()+"\n"+
							account[select].getUser().getLosses());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// metodo per settare gli account in uso
	@Override
	public void setAccount(int select, Account account) {
		// TODO Auto-generated method stub
		this.account[select] = account;
	}

	// metodo per scrivere un nuovo profilo su file
	@Override
	public void writeNewFile(Account account) {
		// TODO Auto-generated method stub
		File credFile = new File(this.filepath);	// opening directory
		String filename = String.valueOf(account.getId());
		File toWrite = new File(credFile,filename);
		try {
			FileWriter myWriter = new FileWriter(toWrite);
			myWriter.write(account.getUsername()+"\n"+
					account.getPassword()+"\n"+
					account.getUser().getName()+"\n"+
					account.getUser().getGender()+"\n"+
					account.getUser().getMatches()+"\n"+
					account.getUser().getWins()+"\n"+
					account.getUser().getLosses());
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Scritto nuovo file");
	}
}
