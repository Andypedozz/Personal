package model;

import interfaces.User;

public class UserImpl implements User{
	private String name;
	private String gender;
	private int matches;
	private int wins;
	private int losses;
	
	public UserImpl(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public UserImpl(String name, String gender, int matches, int wins, int losses) {
		this.name = name;
		this.gender = gender;
		this.matches = matches;
		this.wins = wins;
		this.losses = losses;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	@Override
	public int getMatches() {
		// TODO Auto-generated method stub
		return this.matches;
	}

	@Override
	public int getWins() {
		// TODO Auto-generated method stub
		return this.wins;
	}

	@Override
	public int getLosses() {
		// TODO Auto-generated method stub
		return this.losses;
	}

	@Override
	public void setMatches(int x) {
		// TODO Auto-generated method stub
		this.matches = x;
	}

	@Override
	public void setWins(int x) {
		// TODO Auto-generated method stub
		this.wins = x;
	}

	@Override
	public void setLosses(int x) {
		// TODO Auto-generated method stub
		this.losses = x;
	}

}
