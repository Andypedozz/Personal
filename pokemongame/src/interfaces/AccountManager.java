package interfaces;

import java.util.List;

import model.PairImpl;

public interface AccountManager {
	void loadAccounts();
	List<Account> getAccounts();
	Account getAccount(int select);
	void updateAccount(int select);
	void writeNewFile(Account account);
	void setAccount(int select, Account account);	
}
