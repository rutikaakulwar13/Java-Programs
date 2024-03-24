package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
			System.out.println("Enter the product code:");
			int code=sc.nextInt();
			System.out.println("Enter product name:");
			String name=sc.next();
			System.out.println("Enter the price of product");
			double price=sc.nextDouble();
			System.out.println("Enter quantity");
			int qty=sc.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			Statement stm=con.createStatement();
			int k=stm.executeUpdate("INSERT INTO PRODUCT60 VALUES("+code+",'"+name+"',"+price+","+qty+")");
			if(k>0)
			{
				System.out.println("Product added successfully...");
				
			}
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
