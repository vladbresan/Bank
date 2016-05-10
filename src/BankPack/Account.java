package BankPack;

import java.io.Serializable;
import java.util.Observable;

public abstract class Account extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int accountId;
	protected double total;
	protected String accountName;

	public Account() {

	}

	public Account(int accountId, double total, String type) {
		super();
		this.accountId = accountId;
		this.total = total;
		this.accountName = type;
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", total=" + total + ", accountName=" + accountName + "]";
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		return true;
	}
}
