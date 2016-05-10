package BankPack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import FileOperations.Operations;
import PersonPack.Person;

public class Bank implements BankProc, Serializable {

	private static final long serialVersionUID = 1L;
	protected Map<Person, Set<Account>> bank = new HashMap<Person, Set<Account>>();
	private Operations op = new Operations();

	public Bank() {
		bank=op.read();
	}

	@Override
	public void addAccount(Person p, Account acc) {
		
		assert isWellFormed() : "Bank isn't consistent";
		assert acc != null : "Invalid account";
		assert p != null : "Invalid person";
		int valPreBank = bank.size();
		if (bank.containsKey(p)) {
			int valPrecAcc = bank.get(p).size();
			bank.get(p).add(acc);
			bank.put(p, bank.get(p));
			assert bank.get(p).size() == valPrecAcc + 1 : "Error adding a new account";
		} else {
			int valPrecAcc = 0;
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(acc);
			bank.put(p, accounts);
			assert bank.get(p).size() == valPrecAcc + 1 : "Error adding new account and new person";
			assert bank.size() == valPreBank + 1 : "Something went wrong";
		}
		op.writeInFile(bank);
		acc.addObserver(p);
	}

	@Override
	public void deleteAccount(Person p, int accId) {
		assert accId > 0 : "Invalid account";
		assert p != null : "Invalid person";
		assert isWellFormed():"Bank isn't consistent";
		int val = bank.size();
		if (bank.get(p).size() == 1) {
			deletePerson(p);
			assert bank.size() == val - 1 : "Something went wrong";
		} else {
			if (bank.containsKey(p)) {
				Set<Account> accounts = bank.get(p);
				int valPrecAcc = bank.get(p).size();
				for (Account ac : accounts) {
					if (ac.getAccountId()==accId) {
						bank.get(p).remove(ac);
						break;
					}
				}
				assert bank.get(p).size() == valPrecAcc - 1 : "ERROR deleting account";
			}
		}
		op.writeInFile(bank);
		assert isWellFormed():"Bank isn't consistent";
	}

	@Override
	public void deposit(Person p, int accountId, double amount) {
		assert isWellFormed() : "Bank isn't consistent";
		assert p != null : "Invalid person";
		assert accountId > 0 : "Invalid account";
		assert amount > 0 : "Invalid amount";
		if (bank.containsKey(p)) {
			Set<Account> accounts = bank.get(p);
			for (Account acc : accounts) {
				if (acc.getAccountId() == accountId) {
					double val = acc.getTotal();
					if (acc.getAccountName().equals("Spending")) {
						acc.deposit(amount);
						assert val + amount == acc.getTotal() : "Deposit ERROR";
					} else {				
						assert amount > 1000 : "Nu te zgarcii...";
						acc.deposit(amount);
					}

				}
			}
		}
		op.writeInFile(bank);
		assert isWellFormed() : "Bank isn't consistent";
	}

	@Override
	public void withdraw(Person p, int accountId, double amount) {
		assert p != null : "Invalid person";
		assert accountId > 0 : "Invalid account";
		assert amount > 0 : "Invalid amount";
		assert isWellFormed() : "Bank isn't consistent";
		if (bank.containsKey(p)) {
			Set<Account> accounts = bank.get(p);
			for (Account acc : accounts) {
				if (acc.getAccountId() == accountId) {
					double val = acc.getTotal();
					assert val >= amount : "N-ai bani sefu...";
					acc.withdraw(amount);
					assert val - amount == acc.getTotal() : "Withdrawal ERROR";
				}
			}
		}
		op.writeInFile(bank);
	}

	public boolean isWellFormed() {
		System.out.println(toString());
		for (Entry<Person, Set<Account>> entry : bank.entrySet()) {
			if (entry.getValue() == null || entry.getValue().isEmpty() || entry.getValue().equals("")){
				return false;
				}
		}
		return true;
	}

	@Override
	public void deletePerson(Person p) {
		assert p != null : "Person not found";
		int val = bank.size();
		bank.remove(p);
		assert bank.size() == val - 1 : "Deleting person ERROR";
		op.writeInFile(bank);
	}

	@Override
	public ArrayList<Person> listPersons() {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		for(Entry<Person, Set<Account>> entry : bank.entrySet()){
			persons.add(entry.getKey());
		}
		return persons;
	}

	@Override
	public Set<Account> listAccounts(Person p) {
		assert p!=null:"Person does not exist";
		assert bank.get(p)!=null:"Person does not exist";
		Set<Account> accounts = new HashSet<Account>();
		for(Account entry : bank.get(p)){
			accounts.add(entry);
		}
		return accounts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bank [bank=" + bank + "]";
	}
}
