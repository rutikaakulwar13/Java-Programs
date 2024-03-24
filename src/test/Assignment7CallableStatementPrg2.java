package test;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class Assignment7CallableStatementPrg2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				CallableStatement cs=con.prepareCall("{call RETIEVEBANK(?,?,?,?,?,?,?,?,?)}");
				System.out.println("Enter account no:");
				Long accno=sc.nextLong();
				cs.setLong(1, accno);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.INTEGER);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.BIGINT);
				
				cs.execute();
				System.out.println("Accno:"+accno);
				System.out.println("Name:"+cs.getString(2));
				System.out.println("Balance:"+cs.getInt(3));
				System.out.println("Account type:"+cs.getString(4));
				System.out.println("City:"+cs.getString(5));
				System.out.println("State:"+cs.getString(6));
				System.out.println("Pincode:"+cs.getInt(7));
				System.out.println("Mail:"+cs.getString(8));
				System.out.println("Phone Number:"+cs.getLong(9));
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
