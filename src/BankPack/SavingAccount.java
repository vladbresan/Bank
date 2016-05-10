package BankPack;

public class SavingAccount extends Account{

	private static final long serialVersionUID = 1L;
	private double interest=0.4;
	
	public SavingAccount() {
	}
	
	public SavingAccount(int accId,double amount,String type) {
		super(accId,amount,type);
	}
	
	@Override
	public void deposit(double amount) {
		if(amount<1000)
			notifyObservers("The amount to be deposited must be larger than 1000");
		else{
			this.total = total + amount + amount*interest;
		}
		setChanged();
		notifyObservers(amount+"were added to account"+this.getAccountId());
	}

	@Override
	public void withdraw(double amount) {
		if(amount>3000){
			notifyObservers("You cannot withdraw a sum larger than 3000");
		}
		else{
			this.total = total - amount;
			
		}
		setChanged();
		notifyObservers(amount+"were withdrawn from account"+this.getAccountId());
	}

}
