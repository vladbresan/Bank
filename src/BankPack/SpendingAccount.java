package BankPack;

public class SpendingAccount extends Account {

	private static final long serialVersionUID = 1L;

	public SpendingAccount() {
	}

	public SpendingAccount(int accId, double amount, String type) {
		super(accId, amount, type);
	}

	@Override
	public void deposit(double amount) {
		if (amount < 10) {
			notifyObservers("You can only deposit an amount larger than 10");
		} else {
			this.total = total + amount;
		}
		setChanged();
		notifyObservers(amount + "were added to account" + this.getAccountId());
	}

	@Override
	public void withdraw(double amount) {
		if (amount % 10 != 0 && amount < 1000) {
			notifyObservers("You can only withdraw an amount smaller than 1000 and multiple of 10");
		} else {
			this.total = total - amount;
		}
		setChanged();
		notifyObservers(amount + "were withdrawn from account" + this.getAccountId());
	}

}
