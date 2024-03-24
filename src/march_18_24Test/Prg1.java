package march_18_24Test;

import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

public class Prg1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try (sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			    PreparedStatement ps1=con.prepareStatement("UPDATE STUDENT1 SET AGE=? WHERE SID=2");
			    ps1.setInt(1, 25);
			    int k=ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("Updated successfully");
				}
				else System.out.println("Invalid id");
			    
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
