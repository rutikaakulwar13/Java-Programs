package march_19_24;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Prg1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				CallableStatement cs=con.prepareCall("{call StudentDetails(?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter Id:");
				String id=sc.next();
				System.out.println("Enter rollno:");
				int rollNo=sc.nextInt();
				System.out.println("Enter name:");
				String name=sc.next();
				System.out.println("Enter Branch:");
				String branch=sc.next();
				System.out.println("Enter house number:");
				int hno=sc.nextInt();
				System.out.println("Enter city:");
				String city=sc.next();
				System.out.println("Enter pincode:");
				int pincode=sc.nextInt();
				System.out.println("Enter mail:");
				String mailID=sc.next();
				System.out.println("Enter phoneno:");
				Long phno=sc.nextLong();
				
				cs.setString(1,id);
				cs.setInt(2,rollNo);
				cs.setString(3,name);
				cs.setString(4,branch);
				cs.setInt(5,hno);
				cs.setString(6,city);
				cs.setInt(7,pincode);
				cs.setString(8,mailID);
				cs.setLong(9,phno);
				cs.execute();
				System.out.println("Uploaded successfully");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
