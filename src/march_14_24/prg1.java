package march_14_24;

import java.sql.*;

import java.util.Scanner;

public class prg1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				System.out.print("Enter username:");
				String userName=sc.next();
				System.out.print("Enter password:");
				String password=sc.next();
				System.out.print("Enter user first name:");
				String uFName=sc.next();
				System.out.print("Enter user last name:");
				String uLName=sc.next();
				System.out.print("Enter user mail id:");
				String maild=sc.next();
				System.out.print("Enter user phone number:");
				Long phNumber=sc.nextLong(); 
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
				Statement stm=con.createStatement();
				int k=stm.executeUpdate("INSERT INTO USERDETAILS VALUES('"+userName+"','"+password+"','"+uFName+"','"+uLName+"','"+maild+"',"+phNumber+")");
				if(k>0)
				{
					System.out.println("User registration Successful!!!");
				}
				else System.out.println("Invalid Process");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
