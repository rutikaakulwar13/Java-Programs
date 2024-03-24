package march_20_24_callableStatements;

import java.util.*;
import java.sql.*;

public class PR2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				CallableStatement cs=con.prepareCall("{call ?:=getEmployeeName(?)}");
				cs.registerOutParameter(1, Types.VARCHAR);
				System.out.println("Enter id:");
				
				int id=sc.nextInt();
				cs.setInt(2, id);
				cs.execute();
				System.out.println("Emp name:"+cs.getString(1));
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
	}
}
