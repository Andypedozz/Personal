package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AccountManager extends FileManager<Account>{

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
					data.getUser().getAge()+"\n"+
					data.getUser().getWeight()+"\n"+
					data.getUser().getHeight());
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
		int accountsLoaded = 0;
		List<File> fileList = this.getAllFiles();
		try {
			for(File f : fileList) {
				Scanner scan = new Scanner(f);
				String username = scan.nextLine();
				String password = scan.nextLine();
				String name = scan.nextLine();
				String gender = scan.nextLine();
				int age = Integer.valueOf(scan.nextLine());
				double weight = Double.valueOf(scan.nextLine());
				double height = Double.valueOf(scan.nextLine());
				int id = Integer.valueOf(f.getName());
				User user = new User(name,gender,age,weight,height);
				Account account = new Account(username,password,user,id);
				this.getDataList().add(account);
				accountsLoaded++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Caricati "+accountsLoaded+" account");
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
							data.getUser().getAge()+"\n"+
							data.getUser().getWeight()+"\n"+
							data.getUser().getHeight());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
