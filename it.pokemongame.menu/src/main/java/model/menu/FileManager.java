package model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    private static FileManager INSTANCE = null;
    private Map<String,String> credMap;
    private Map<String,Account> dataList;
    private Map<String,Account> usedData;
    private int lastId;
    private File directory;

    private FileManager() {
        this.dataList = new HashMap<>();
        this.usedData = new HashMap<>();
        this.credMap = new HashMap<>();
    }

    public static FileManager getInstance() {
        if(INSTANCE == null)
            INSTANCE = new FileManager();
        return INSTANCE;
    }

    public void openDirectory(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        if(!file.exists())
            throw new FileNotFoundException("Directory non trovata");
        this.directory = new File(filepath);
    }

    public File getOpenDirectory() {
        return this.directory;
    }

    public void openFileDirectory(String filepath) throws FileNotFoundException{
		File file = new File(filepath);
		if(!file.exists())
			throw new FileNotFoundException("Directory non trovata!");
		this.directory = new File(filepath);
	}
	
	public void closeFileDirectory() {
		this.directory = null;
	}

    public Map<String,Account> getDataMap() {
        return this.dataList;
    }

    public Map<String,Account> getUsedData() {
        return this.usedData;
    }

    public Map<String,String> getCredMap() {
        return this.credMap;
    }

    public List<File> getAllFiles() {
        List<File> fileList = Arrays.asList(this.directory.listFiles());
        return fileList;
    }

    public boolean readFromFile() {
        List<File> fileList = null;
		boolean read = true;
		try {
			fileList = this.getAllFiles();
		}catch(NullPointerException e) {
			read = false;
		}
		
		if(read) {
			int lastId = -1, accountsLoaded = 0;
			
            System.out.println("Lettura da file...");
			if(fileList != null) {
				try {
					for(File f : fileList) {
						Scanner scan = new Scanner(f);
						lastId = Integer.valueOf(f.getName());
						System.out.println("Caricamento dati account...");
						while(scan.hasNextLine()) {
							String username = scan.nextLine();
							String hashedPassword = scan.nextLine();
							int matches = Integer.parseInt(scan.nextLine());
							int wins = Integer.parseInt(scan.nextLine());
							int losses = Integer.parseInt(scan.nextLine());
							Account account = new Account(username,hashedPassword,lastId,matches,wins,losses);
                            this.getCredMap().put(username, hashedPassword);
							this.getDataMap().put(username,account);
							accountsLoaded++;
						}
						scan.close();
					}
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
			}
			System.out.println(accountsLoaded+" account caricati correttamente!");
            this.lastId = lastId;
		}else
			System.out.println("Directory non trovata!");
        return read;
    }

    public boolean writeNewFile(Account account) {
        boolean result = true;
        File credFile = this.getOpenDirectory();
		String filename = String.valueOf(account.getId());
		File toWrite = new File(credFile,filename);
		try {
			FileWriter myWriter = new FileWriter(toWrite);
			myWriter.write(account.getUsername()+"\n"+
					account.getPassword()+"\n"+
					0+"\n"+
					0+"\n"+
					0);
			myWriter.close();
            System.out.println("Scritto nuovo file");
		} catch (IOException e) {
            System.out.println(e);
			result = false;
		}
        return result;
    }

    public boolean updateFile(Account account) {
        return false;
    }

    public int getLastId() {
        return this.lastId;
    }
}
