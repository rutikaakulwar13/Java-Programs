package march_18_24Test;
//1) Write a Java program using JDBC to insert a new record into the "employees" table with columns: id, name, age, and department.

import java.util.Scanner;
import java.sql.*;

public class SetAPrg1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		PreparedStatement ps1=con.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?)");
		System.out.println("Enter id:");
		int id=sc.nextInt();
		ps1.setInt(1, id);
		System.out.println("Enter name:");
		String name=sc.next();
		ps1.setString(2, name);
		System.out.println("Enter age:");
		int age=sc.nextInt();
		ps1.setInt(3, age);
		System.out.println("enter Department");
		String dpt=sc.next();
		ps1.setString(4, dpt);
		int k=ps1.executeUpdate();
		if(k>0)
		{
			System.out.println("Inserted successfully");
		}
		
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
