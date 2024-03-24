package test;

import java.sql.*;
import java.util.Scanner;

public class Assignment3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			try {
				System.out.println("Enter employee id");
				int eid=sc.nextInt();
				System.out.println("Enter employee name");
				String ename=sc.next();
				System.out.println("Enter employee designation");
				String edesg=sc.next();
				System.out.println("Enter basic salary");
				double sal=sc.nextDouble();
				//loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//creating connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				//preparing statement
				Statement stm=con.createStatement();
				//Executing query
				int k=stm.executeUpdate("Insert into EMPLOYEE60 values("+eid+",'"+ename+"','"+edesg+"',"+sal+","+((sal*93)/100)+","+((sal*61)/100)+","+(((sal*93)/100)+((sal*61)/100)+sal)+")");
				if(k>0)
				{
					System.out.println("Employee data updated successfully");
					
				}
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
