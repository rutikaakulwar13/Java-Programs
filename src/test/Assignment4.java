package test;
import java.sql.*;
public class Assignment4 {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM EMPLOYEE60");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7));
		}
		con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
