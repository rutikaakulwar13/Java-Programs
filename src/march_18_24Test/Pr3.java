package march_18_24Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Pr3 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		    Statement stm=con.createStatement();
		    int k=stm.executeUpdate("DELETE FROM ORDERS WHERE OID=1");
		    if(k>0)
		    {
		    	System.out.println("Deleted successfully");
		    }
	}
		catch (Exception e) {
			e.printStackTrace();
		}
}
}
