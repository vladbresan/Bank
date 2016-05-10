package GuiPack;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GUI {

	private JFrame frmBank;
	public JTextField firstNameField;
	public JTextField lastNameField;
	public JTextField cnpField;
	public JTextField accountIdField;
	public JTextField amountField;
	public JTable clientsTable;
	public JTable accountsTable;
	public JButton btnAddSavingAccount;
	public JButton btnAddSpendingAccount;
	public JButton btnRemoveClient;
	public JButton btnRemoveAccount;
	public JButton btnAddMoney;
	public JButton btnWithdrawMoney;
	public JButton btnSeeClients;
	public JButton btnSeeAccounts;
	public DefaultTableModel model;
	public DefaultTableModel model1;
	public JLabel idLabel;

	public GUI() {
		initialize();
	}

	private void initialize() {
		frmBank = new JFrame();
		frmBank.setTitle("Bank");
		frmBank.setBackground(Color.LIGHT_GRAY);
		frmBank.setBounds(100, 100, 880, 500);
		frmBank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBank.getContentPane().setLayout(null);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(70, 11, 120, 20);
		frmBank.getContentPane().add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(0, 14, 71, 14);
		frmBank.getContentPane().add(lblFirstName);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(70, 42, 120, 20);
		frmBank.getContentPane().add(lastNameField);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(0, 45, 71, 14);
		frmBank.getContentPane().add(lblLastName);
		
		cnpField = new JTextField();
		cnpField.setColumns(10);
		cnpField.setBounds(70, 73, 120, 20);
		frmBank.getContentPane().add(cnpField);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnp.setBounds(0, 76, 71, 14);
		frmBank.getContentPane().add(lblCnp);
		
		btnAddSavingAccount = new JButton("Add Saving Account");
		btnAddSavingAccount.setBounds(10, 166, 180, 23);
		frmBank.getContentPane().add(btnAddSavingAccount);
		
		accountIdField = new JTextField();
		accountIdField.setColumns(10);
		accountIdField.setBounds(70, 104, 120, 20);
		frmBank.getContentPane().add(accountIdField);
		
		JLabel lblAccountId = new JLabel("Account ID");
		lblAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountId.setBounds(0, 107, 71, 14);
		frmBank.getContentPane().add(lblAccountId);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountField.setBounds(70, 135, 120, 20);
		frmBank.getContentPane().add(amountField);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(0, 138, 71, 14);
		frmBank.getContentPane().add(lblAmount);
		
		btnAddSpendingAccount = new JButton("Add Spending Account");
		btnAddSpendingAccount.setBounds(10, 200, 180, 23);
		frmBank.getContentPane().add(btnAddSpendingAccount);
		
		btnRemoveClient = new JButton("Remove Client");
		btnRemoveClient.setBounds(10, 234, 180, 23);
		frmBank.getContentPane().add(btnRemoveClient);
		
		btnRemoveAccount = new JButton("Remove Account");
		btnRemoveAccount.setBounds(10, 268, 180, 23);
		frmBank.getContentPane().add(btnRemoveAccount);
		
		btnAddMoney = new JButton("Add money");
		btnAddMoney.setBounds(10, 302, 180, 23);
		frmBank.getContentPane().add(btnAddMoney);
		
		btnWithdrawMoney = new JButton("Withdraw money");
		btnWithdrawMoney.setBounds(10, 336, 180, 23);
		frmBank.getContentPane().add(btnWithdrawMoney);
		
		btnSeeClients = new JButton("See clients");
		btnSeeClients.setBounds(10, 370, 180, 23);
		frmBank.getContentPane().add(btnSeeClients);
		
		btnSeeAccounts = new JButton("See accounts");
		btnSeeAccounts.setBounds(10, 404, 180, 23);
		frmBank.getContentPane().add(btnSeeAccounts);
		
		clientsTable = new JTable();
		model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First name", "Last name", "CNP"
			});
		clientsTable = new JTable(model);
	//	clientsTable.setBorder(new TitledBorder(null, "Clients", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clientsTable.setBounds(200, 14, 320, 413);
		frmBank.getContentPane().add(clientsTable);
		
		accountsTable = new JTable();
		model1 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account ID", "Type", "Amount"
			}
		);
		accountsTable = new JTable(model1);
	//	accountsTable.setBorder(new TitledBorder(null, "Accounts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		accountsTable.setBounds(530, 14, 320, 413);
		frmBank.getContentPane().add(accountsTable);
		
		JLabel lblNextAccountId = new JLabel("Next account id available");
		lblNextAccountId.setBounds(530, 438, 162, 14);
		frmBank.getContentPane().add(lblNextAccountId);
		
		idLabel = new JLabel("New label");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(664, 438, 64, 14);
		frmBank.getContentPane().add(idLabel);
		
		frmBank.setVisible(true);
	}
}
