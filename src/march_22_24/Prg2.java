package march_22_24;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Prg2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
				CallableStatement cs=con.prepareCall("{call ?:=stu_info(?)}");
				cs.registerOutParameter(1, Types.VARCHAR);
				System.out.println("Enter roll no of student:");
				int rollNo=sc.nextInt();
				cs.setInt(2, rollNo);
				cs.execute();
				System.out.println("Student Address:"+cs.getString(1));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
