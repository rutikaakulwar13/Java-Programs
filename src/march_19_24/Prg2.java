package march_19_24;

import java.sql.*;
import java.util.Scanner;

public class Prg2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				CallableStatement cs=con.prepareCall("{call RETRIEVEStudentDetails(?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter id");
				String id=sc.next();
				cs.setString(1, id);
				cs.registerOutParameter(2, Types.INTEGER);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.INTEGER);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.BIGINT);
				cs.execute();
				System.out.println("Student id:"+id);
				System.out.println("Student Roll no:"+cs.getInt(2));
				System.out.println("Student name:"+cs.getString(3));
				System.out.println("Student branch:"+cs.getString(4));
				System.out.println("Student House number:"+cs.getInt(5));
				System.out.println("Student city:"+cs.getString(6));
				System.out.println("Student pincode:"+cs.getInt(7));
				System.out.println("Student Mail id:"+cs.getString(8));
				System.out.println("Student Phone number:"+cs.getLong(9));
				
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
