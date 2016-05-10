package FileOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import BankPack.Account;
import PersonPack.Person;

public class Operations {
	public Operations(){
		
	}
	
	public Map<Person,Set<Account>> read(){
		FileInputStream fileIn;
		Map<Person,Set<Account>> obj = new HashMap<Person,Set<Account>>();
		try{
			fileIn = new FileInputStream("Bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = (Map<Person, Set<Account>>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return obj;
	}
	
	public void writeInFile(Map<Person,Set<Account>> bankRecords){
		try{
			FileOutputStream fileOut = new FileOutputStream("Bank.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bankRecords);
			out.close();
			fileOut.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
