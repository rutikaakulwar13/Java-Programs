package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Assignment7 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				CallableStatement cs=con.prepareCall("{call BANK1(?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter acc no:");
				long acc=Long.parseLong(sc.next());
				
				System.out.println("Enter customer name:");
				String name=sc.next();
				
				System.out.println("Enter balance:");
				int balance=sc.nextInt();
				
				System.out.println("Enter account type:");
				String atype=sc.next();
				
				System.out.println("Enter city:");
				String city=sc.next();
				
				System.out.println("Enter state:");
				String state=sc.next();
				
				System.out.println("Enter pincode:");
				Long pincode=Long.parseLong(sc.next());
				
				System.out.println("Enter mail:");
				String email=sc.next();
				
				System.out.println("Enter phone number:");
				Long phno=sc.nextLong();
				
				cs.setLong(1, acc);
				cs.setString(2, name);
				cs.setInt(3, balance);
				cs.setString(4, atype);
				cs.setString(5, city);
				cs.setString(6, state);
				cs.setLong(7, pincode);
				cs.setString(8, email);
				cs.setLong(9, phno);
				
				cs.execute();
				System.out.println("Bank customer details updated sucessfully");
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
