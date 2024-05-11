package interfaces;

public interface LoginObserver {
	void initLogin();
	void register(String username, String password, String name, String gender);
	void login(int select, String username, String password);
	void disconnect(int select);
}
