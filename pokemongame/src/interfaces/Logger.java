package interfaces;

public interface Logger {
	int login(int select, String username, String password);
	void register(String username, String password, String name, String gender);
	void disconnect(int select);
	boolean ready();
}
