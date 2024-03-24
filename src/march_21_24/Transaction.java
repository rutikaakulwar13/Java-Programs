package march_21_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaction {
	static Connection con;
	static PreparedStatement ps1;
	static PreparedStatement ps2;
	static ResultSet rs;
	private double senderAccount;
	private double receiverAccount;
	private double transferAmount;
	private double balance;
	static {
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public double  getAccountBalance(double senderAccount,double transferAmount)
	{
//		senderAccount = 123456;
//		receiverAccount = 654321;
//		transferAmount = 500.0;
//		balance=0;
		try {
		ps1=con.prepareStatement("SELECT * from ACCOUNTS where AACOUNT_NUMBER=?");
		ps1.setDouble(1, senderAccount);
		rs=ps1.executeQuery();
		if(rs.next())
		{
			//System.out.println(rs.getDouble(1)+" "+rs.getDouble(2));
			 balance=rs.getDouble(2);
			 
		}
		else {
			System.out.println("Invalid account number");
		con.setAutoCommit(false);
			con.rollback();
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	public void updateAccountBalance(double sAccountNo,double newamt)
	{
		try {

		ps2=con.prepareStatement("Update ACCOUNTS set BALANCE=BALANCE+? WHERE AACOUNT_NUMBER=?");
		ps2.setDouble(1, newamt);
		ps2.setDouble(2, sAccountNo);
		int k=ps2.executeUpdate();
		if(k>0)
		{
			System.out.println("transaction successfull");
		}
		else {
			System.out.println("Transaction failed");
			con.rollback();
		}
		
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	public double getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(double senderAccount) {
		this.senderAccount = senderAccount;
	}
	public double getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(double receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public double getSendersBalance() {
		return balance;
	}
	public void setSendersBalance(double sendersBalance) {
		this.balance = sendersBalance;
	}
	
	
}
