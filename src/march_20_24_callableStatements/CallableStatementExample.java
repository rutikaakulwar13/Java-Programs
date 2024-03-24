package march_20_24_callableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementExample {

		static Connection con=null;
		
	public void callStatement()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			
			CallableStatement cs=con.prepareCall("{call ?:= getTotalEmployees()}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println("total Employees:"+cs.getInt(1));
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
