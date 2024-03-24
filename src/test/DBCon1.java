package test;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBCon1 {
	public static void main(String[] args)  {
		try {
			//Step 1:Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step 2:Creating Connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
			//Step 3:Preparing Statement
			Statement stm=con.createStatement();
			//Step 4:Executing Query
			ResultSet rs=stm.executeQuery("SELECT * FROM CUSTOMER60");
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			//Step 5:Close Connection
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
	}
}
