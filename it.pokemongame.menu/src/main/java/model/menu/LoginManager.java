package model.menu;

import java.io.FileNotFoundException;

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
        String hashedPassword = Hashing.hashString(password);
        String storedHashedPassword = this.fileManager.getCredMap().get(username);

        if(storedHashedPassword != null && storedHashedPassword.equals(hashedPassword)) {
            Account toLogin = this.fileManager.getDataMap().get(username);
            if(!toLogin.isLogged()) {
                this.accounts[select] = toLogin;
                toLogin.setLogged(true);
                this.logged[select] = true;
                exit = 0;
                System.out.println("Profilo "+select+" loggato come "+toLogin.getUsername());
            }else{
                exit = 3;
                System.out.println("Account già in uso");
            }
        }else{
            if(!this.fileManager.getCredMap().containsKey(username) || !this.fileManager.getCredMap().containsValue(hashedPassword)) {
                exit = 1;
                System.out.println("Account non trovato!");
            }else if(this.accounts[select] != null) {
                exit = 2;
                System.out.println("Profilo occupato");
            }
        }
        return exit;
    }

    public boolean register(String username, String password) throws FileNotFoundException {
        // casistiche di successo: username non è già presente
        boolean result = this.fileManager.getCredMap().containsKey(username);


        // se non c'è
        if(!result) {
            String hashedPassword = Hashing.hashString(password);
            int id = this.fileManager.getLastId() + 1;
            Account toRegister = new Account(username, hashedPassword,id);
            this.fileManager.getCredMap().put(username, hashedPassword);
            this.fileManager.getDataMap().put(username, toRegister);
            this.fileManager.writeNewFile(toRegister);
            System.out.println("Registrato con successo");
        }else{
            System.out.println("Username già utilizzato!");
        }
        return result;
    }
    
    public boolean registerNoWrite(String username, String password) {
        // casistiche di successo: username non è già presente
        boolean result = this.fileManager.getCredMap().containsKey(username);


        // se non c'è
        if(!result) {
            String hashedPassword = Hashing.hashString(password);
            Account toRegister = new Account(username, hashedPassword);
            this.fileManager.getCredMap().put(username, hashedPassword);
            this.fileManager.getDataMap().put(username, toRegister);
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
