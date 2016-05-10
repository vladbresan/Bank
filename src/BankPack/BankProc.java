/**
 * 
 */
package BankPack;

import java.util.ArrayList;
import java.util.Set;

import PersonPack.Person;

/**
 * @author Vlad
 *
 */
public interface BankProc {
	/**
	 * @pre acc != null p!=null
	 * @post size = prev size +1;
	 * @param acc - the account to be added 
	 * @return 
	 */
	public void addAccount(Person p,Account acc);
	/**
	 * @pre acc!=null && p!=null
	 * @post size = prev size -1;
	 * @param acc - the account to be deleted
	 * @return 
	 */
	public void deleteAccount(Person p,int accId);
	/**
	 * @pre accountId > 0 && amount > 0 
	 * @post 
	 * @param
	 * @return 
	 */
	public void deposit(Person p,int accountId,double amount);
	/**
	 * @pre accountId > 0 && amount <= total && amount > 0
	 * @post 
	 * @param
	 * @return 
	 */
	public void withdraw(Person p,int accountId,double amount);
	
	/**
	 * @pre p!=null
	 * @post size = prev size -1;
	 * @param p
	 * @return 
	 */
	public void deletePerson(Person p);
	
	/**
	 * @pre 
	 * @post
	 * @return an ArrayList of persons
	 */
	public ArrayList<Person> listPersons();
	/**
	 * @pre 
	 * @post
	 * @return a Set of accounts 
	 */
	public Set<Account> listAccounts(Person p);
}
