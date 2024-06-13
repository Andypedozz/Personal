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
import java.util.Set;

import model.Pair;

public class FileManager {
    private static FileManager INSTANCE = null;
    private Map<Pair<String,String>,Account> dataList;
    private Map<Pair<String,String>,Account> usedData;
    private Map<String,File> usedFiles;
    private File directory;

    private FileManager() {
        this.dataList = new HashMap<>();
        this.usedData = new HashMap<>();
        this.usedFiles = new HashMap<>();
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

    public Map<Pair<String,String>,Account> getDataMap() {
        return this.dataList;
    }

    public Map<Pair<String,String>,Account> getUsedData() {
        return this.usedData;
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
			int lastId = 0, accountsLoaded = 0;
			
            System.out.println("Lettura da file...");
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
							Account account = new Account(username,password,lastId,matches,wins,losses);
                            Pair<String,String> creds = new Pair<>(username,password);
							this.getDataMap().put(creds,account);
							accountsLoaded++;
						}
						scan.close();
					}
				} catch (FileNotFoundException e) {
					System.out.println(e);
				}
			}
			System.out.println(accountsLoaded+" account caricati correttamente!");
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

    public void printMap() {
        Set<Pair<String,String>> keySet = this.dataList.keySet();
        for(Pair<String,String> cred : keySet) {
            System.out.println("Username: "+cred.getFirst());
        }
    }

    public Pair<String,String> getKey(String username, String password) {
        Set<Pair<String,String>> keySet = this.dataList.keySet();
        Pair<String,String> credentials = null;
        for(Pair<String,String> key : keySet) {
            if(key.getFirst().equals(username) && key.getSecond().equals(password))
                credentials = key;
        }
        return credentials;
    }
}
