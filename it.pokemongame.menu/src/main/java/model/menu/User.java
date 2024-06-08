package model.menu;

public class User {
	private String name;
	private String gender;
	private int matches;
	private int wins;
	private int losses;
	
	public User(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public User(String name, String gender, int matches, int wins, int losses) {
		this.name = name;
		this.gender = gender;
		this.matches = matches;
		this.wins = wins;
		this.losses = losses;
	}
	
	
	public String getName() {
		return this.name;
	}

	
	public String getGender() {
		return this.gender;
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

	
	public void setMatches(int x) {
		this.matches = x;
	}

	
	public void setWins(int x) {
		this.wins = x;
	}

	
	public void setLosses(int x) {
		this.losses = x;
	}

}
