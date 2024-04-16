package interfaces;

public interface User {
	String getName();
	String getGender();
	int getMatches();
	int getWins();
	int getLosses();
	void setMatches(int x);
	void setWins(int x);
	void setLosses(int x);
}
