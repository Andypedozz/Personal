package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import interfaces.Account;
import interfaces.User;

public class AccountManager2 extends FileManager<Account>{

	
	@Override
	public void writeNewFile(Account data) {
		// TODO Auto-generated method stub
		File credFile = this.getOpenedDirectory();
		String filename = String.valueOf(data.getId());
		File toWrite = new File(credFile,filename);
		try {
			FileWriter myWriter = new FileWriter(toWrite);
			myWriter.write(data.getUsername()+"\n"+
					data.getPassword()+"\n"+
					data.getUser().getName()+"\n"+
					data.getUser().getGender()+"\n"+
					data.getUser().getMatches()+"\n"+
					data.getUser().getWins()+"\n"+
					data.getUser().getLosses());
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Scritto nuovo file");
	}

	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub
		List<File> fileList = this.getAllFiles();
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
						this.getDataList().add(account);
						accountsLoaded++;
					}
					scan.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
		}
		System.out.println(accountsLoaded+" account caricati correttamente!");
	}

	@Override
	public void updateFile(Account data) {
		// TODO Auto-generated method stub
		for(File f : this.getAllFiles()) {
			if(String.valueOf(data.getId()).equals(f.getName())) {
				f.delete();
				File updated = new File(String.valueOf(data.getId()));
				try {
					FileWriter myWriter = new FileWriter(String.valueOf(data.getId()));
					myWriter.write(data.getUsername()+"\n"+
							data.getPassword()+"\n"+
							data.getUser().getName()+"\n"+
							data.getUser().getGender()+"\n"+
							data.getUser().getMatches()+"\n"+
							data.getUser().getWins()+"\n"+
							data.getUser().getLosses());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
