package model;

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
		// TODO Auto-generated method stub
		return this.name;
	}

	
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	
	public int getMatches() {
		// TODO Auto-generated method stub
		return this.matches;
	}

	
	public int getWins() {
		// TODO Auto-generated method stub
		return this.wins;
	}

	
	public int getLosses() {
		// TODO Auto-generated method stub
		return this.losses;
	}

	
	public void setMatches(int x) {
		// TODO Auto-generated method stub
		this.matches = x;
	}

	
	public void setWins(int x) {
		// TODO Auto-generated method stub
		this.wins = x;
	}

	
	public void setLosses(int x) {
		// TODO Auto-generated method stub
		this.losses = x;
	}

}
