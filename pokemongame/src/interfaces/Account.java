package interfaces;

public interface Account {
	String getUsername();
	String getPassword();
	User getUser();
	int getId();
	boolean getState();
	void setState(boolean state);
}
