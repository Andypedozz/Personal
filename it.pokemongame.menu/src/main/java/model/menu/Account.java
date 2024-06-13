package model.menu;

public class Account {
    private String username;
    private String password;
    private int id;
    private int matches;
    private int wins;
    private int losses;
    private boolean logged;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.matches = 0;
        this.wins = 0;
        this.losses = 0;
        this.logged = false;
    }

    public Account(String username, String password, int id, int matches, int wins, int losses) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.matches = matches;
        this.wins = wins;
        this.losses = losses;
        this.logged = false;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getId() {
        return this.id;
    }

    public int getMatches() {
        return this.matches;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public boolean isLogged() {
        return this.logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
