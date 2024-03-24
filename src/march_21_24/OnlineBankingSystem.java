package march_21_24;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class OnlineBankingSystem {
	static Connection con;
	static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
		con.setAutoCommit(false);
		Savepoint sp=con.setSavepoint();
		
		Transaction t= new Transaction();
		System.out.println("Enter sender's account number");
		long senderAccount=sc.nextLong();
		System.out.println("Enter amount to tranfer");
		double transferAmount=sc.nextDouble();
		double senderbalance=t.getAccountBalance(senderAccount, transferAmount);
		//System.out.println(senderbalance);
		if(senderbalance>=transferAmount)
		{
		t.updateAccountBalance(senderAccount, (-transferAmount));
		}
		else {
			System.out.println("Insufficient funds...");
			System.exit(0);
		}
		System.out.println("Enter receiver account number:");
		long recevierAccount=sc.nextLong();
		double receiverbalance=t.getAccountBalance(recevierAccount, transferAmount);
		t.updateAccountBalance(recevierAccount, transferAmount);
		con.setAutoCommit(true);
		
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
	}
	
	
	
	
}
