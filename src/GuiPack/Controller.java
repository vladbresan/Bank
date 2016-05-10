package GuiPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BankPack.Account;
import BankPack.Bank;
import BankPack.SavingAccount;
import BankPack.SpendingAccount;
import PersonPack.Person;

public class Controller {
	String fN, lN, cnp;
	int accountId;
	double amount;
	private GUI guiObj;
	private Bank bankObj = new Bank();


	public Controller() {
		guiObj = new GUI();
		actions();
	}

	private void actions() {
		guiObj.idLabel.setText(String.valueOf(getMaxId()+1));
		guiObj.btnAddSavingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				assert checkAccId(accountId) : "Account ID already exists";
				Account savingAcc = new SavingAccount(accountId, amount, "Saving");
				bankObj.addAccount(pers, savingAcc);
				guiObj.idLabel.setText(String.valueOf(getMaxId()+1));
			}
		});
		guiObj.btnAddSpendingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				assert checkAccId(accountId) : "Account ID already exists";
				Account spendingAcc = new SpendingAccount(accountId, amount, "Spending");
				bankObj.addAccount(pers, spendingAcc);
				guiObj.idLabel.setText(String.valueOf(getMaxId()+1));
			}
		});
		guiObj.btnRemoveClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				bankObj.deletePerson(pers);
			}
		});
		guiObj.btnRemoveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				bankObj.deleteAccount(pers, accountId);
			}
		});
		guiObj.btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				bankObj.deposit(pers, accountId, amount);
			}
		});
		guiObj.btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				Person pers = new Person(fN, lN, cnp);
				bankObj.withdraw(pers, accountId, amount);
			}
		});
		guiObj.btnSeeClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assert bankObj.isWellFormed() : "Bank is inconsistent";
				guiObj.accountsTable = new JTable(guiObj.model);
				guiObj.accountIdField.repaint();
				ArrayList<Person> person = new ArrayList<Person>();
				person.addAll(bankObj.listPersons());

				for (Person pers : person) {
					Object ob[] = { pers.getFirstName(), pers.getLastName(), pers.getCnp() };
					guiObj.model.addRow(ob);
				}
			}
		});
		guiObj.btnSeeAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getField();
				guiObj.accountsTable = new JTable(guiObj.model1);
				guiObj.accountIdField.repaint();
				Person p = new Person(fN, lN, cnp);
				Set<Account> accounts = bankObj.listAccounts(p);
				for (Account ac : accounts) {
					Object ob[] = { ac.getAccountId(), ac.getAccountName(), ac.getTotal() };
					guiObj.model1.addRow(ob);
				}
			}
		});
		guiObj.clientsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				guiObj.firstNameField.setText((String)guiObj.clientsTable.getValueAt(guiObj.clientsTable.getSelectedRow(),0));
				guiObj.lastNameField.setText((String)guiObj.clientsTable.getValueAt(guiObj.clientsTable.getSelectedRow(),1));
				guiObj.cnpField.setText((String)guiObj.clientsTable.getValueAt(guiObj.clientsTable.getSelectedRow(),2));
			}
		});
		guiObj.accountsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				guiObj.accountIdField.setText(String.valueOf((guiObj.accountsTable.getValueAt(guiObj.accountsTable.getSelectedRow(),0))));
				
			}
		});
	}

	private int getMaxId(){
		int max=0;
		ArrayList<Person> person = new ArrayList<Person>();
		person.addAll(bankObj.listPersons());

		for (Person pers : person) {
			Set<Account> accounts = bankObj.listAccounts(pers);
			for (Account ac : accounts) {
				if(max<ac.getAccountId())
					max=ac.getAccountId();
				}
			}
		return max;
	}
	
	private boolean checkAccId(int accId) {
		ArrayList<Person> person = new ArrayList<Person>();
		person.addAll(bankObj.listPersons());

		for (Person pers : person) {
			Set<Account> accounts = bankObj.listAccounts(pers);
			for (Account ac : accounts) {
				if (ac.getAccountId() == accId) {
					return false;
				}
			}
		}
		return true;
	}

	private void getField() {
		fN = guiObj.firstNameField.getText();
		lN = guiObj.lastNameField.getText();
		cnp = guiObj.cnpField.getText();
		assert cnp.length()==13:"Invalid CNP";
		accountId = Integer.parseInt(guiObj.accountIdField.getText());
		amount = Double.parseDouble(guiObj.amountField.getText());
	}
}
