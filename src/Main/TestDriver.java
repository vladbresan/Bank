package Main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import BankPack.Account;
import BankPack.Bank;
import BankPack.SpendingAccount;
import PersonPack.Person;

public class TestDriver {
	private Bank toTest = new Bank();
	private Person pers = new Person("Vlad","Bresan","1950818011161");
	
	@Test
	public final void addAccTest(){
		Account acc = new SpendingAccount(99, 10, "Spending");
		toTest.addAccount(pers, acc);
		assertEquals(toTest.listPersons().size(),3);
		acc.deposit(10);
		assertEquals(acc.getTotal(), 20.0,2);

	}
}
