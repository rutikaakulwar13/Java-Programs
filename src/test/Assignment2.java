package test;

import java.sql.*;
import java.sql.DriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("SELECT * FROM PRODUCT60");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(1)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
