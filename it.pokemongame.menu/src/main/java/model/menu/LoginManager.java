package model.menu;

import java.io.FileNotFoundException;
import java.util.Map.Entry;
import model.Pair;
import java.util.Set;

public class LoginManager {
    private static LoginManager INSTANCE;
    private FileManager fileManager;
    private Account accounts[];
    private boolean logged[];

    private LoginManager() {
        this.fileManager = FileManager.getInstance();
        this.accounts = new Account[2];
        this.logged = new boolean[2];
    }

    public static LoginManager getInstance() {
        if(INSTANCE == null)
            INSTANCE = new LoginManager();
        return INSTANCE;
    }

    public int login(String username, String password, int select) {
        int exit = 0;
        Pair<String,String> credentials = this.fileManager.getKey(username, password);
        
        Account toLogin = this.fileManager.getDataMap().get(credentials);
        if(toLogin != null && this.accounts[select] == null && !toLogin.isLogged()) {
            this.accounts[select] = toLogin;
            toLogin.setLogged(true);
            this.logged[select] = true;
            exit = 0;
            System.out.println("Profilo "+select+" loggato come "+toLogin.getUsername());
        }else{
            if(!this.fileManager.getDataMap().containsKey(credentials)) {
                exit = 1;
                System.out.println("Account non trovato!");
            }else if(this.accounts[select] != null) {
                exit = 2;
                System.out.println("Profilo occupato");
            }else if(toLogin.isLogged()) {
                exit = 3;
                System.out.println("Account già in uso");
            }
        }
        return exit;
    }

    public boolean register(String username, String password) throws FileNotFoundException {
        // casistiche di successo: username non è già presente
        boolean result = true;
        Set<Entry<Pair<String,String>,Account>> set = this.fileManager.getDataMap().entrySet();

        // controllo se è già presente un account con l'username inserito
        for(Entry<Pair<String,String>,Account> entry : set) {
            if(entry.getKey().getFirst().equals(username))
                result = false;
        }

        // se non c'è
        if(result) {
            Account toRegister = new Account(username, password);
            Pair<String,String> creds = new Pair<>(username,password);
            this.fileManager.getDataMap().put(creds, toRegister);
            this.fileManager.writeNewFile(toRegister);
            System.out.println("Registrato con successo");
        }else{
            System.out.println("Username già utilizzato!");
        }
        return result;
    }
    
    public boolean registerNoWrite(String username, String password) {
    	// casistiche di successo: username non è già presente
        boolean result = true;
        Set<Entry<Pair<String,String>,Account>> set = this.fileManager.getDataMap().entrySet();

        // controllo se è già presente un account con l'username inserito
        for(Entry<Pair<String,String>,Account> entry : set) {
            if(entry.getKey().getFirst().equals(username))
                result = false;
        }

        // se non c'è
        if(result) {
            Account toRegister = new Account(username, password);
            Pair<String,String> creds = new Pair<>(username,password);
            this.fileManager.getDataMap().put(creds, toRegister);
            System.out.println("Registrato con successo");
        }else{
            System.out.println("Username già utilizzato!");
        }
        return result;
    }

    public boolean disconnect(int select) {
        boolean result = true;

        if(this.accounts[select] != null) {
			this.accounts[select].setLogged(false);
			System.out.println("Profilo "+select+" ("+this.accounts[select].getUsername()+") disconnesso");
			this.accounts[select] = null;
			this.logged[select] = false;
		}else{
			System.out.println("Profilo "+select+" non loggato!");
			result = false;
		}
        return result;
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }

    public boolean ready() {
        return this.logged[0] && this.logged[1];
    }
}
