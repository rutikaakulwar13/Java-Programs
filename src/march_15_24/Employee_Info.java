package march_15_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Employee_Info {
	static Connection con=null;
	static PreparedStatement insert=null;
	static PreparedStatement deleteBySal=null;
	static PreparedStatement select=null;
	static PreparedStatement selectByStartWithName=null;
	static PreparedStatement salaryInBetween=null;
	static PreparedStatement updateById=null;
	static PreparedStatement selectByName=null;
	static PreparedStatement deleteByName=null;
	static Scanner sc=new Scanner(System.in);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			insert=con.prepareStatement("Insert into EMPLOYEE_INFO values(?,?,?,?,?,?)");
			select=con.prepareStatement("Select * from EMPLOYEE_INFO");
			selectByStartWithName=con.prepareStatement("Select * from EMPLOYEE_INFO where EMPNAME like'S%'");
			salaryInBetween=con.prepareStatement("Select * from EMPLOYEE_INFO where  EMPSALARY between 10000 and 20000");
			updateById=con.prepareStatement("Update EMPLOYEE_INFO set EMPSALARY=? where EMPID=?");
			deleteBySal=con.prepareStatement("Delete from EMPLOYEE_INFO where EMPSALARY=(Select MAX(EMPSALARY) from  EMPLOYEE_INFO)");
			deleteByName=con.prepareStatement("Delete from EMPLOYEE_INFO where EMPNAME=(Select EMPNAME from  EMPLOYEE_INFO  where EMPNAME like'%a')");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static void insert()
		{
			
			try {
				System.out.println("Enter emp id");
				int id=sc.nextInt();
				System.out.println("Enter emp name");
				String name=sc.next();
				System.out.println("Enter emp salary");
				double sal=sc.nextDouble();
				System.out.println("Enter emp address");
				String add=sc.next();
				System.out.println("Enter emp mail id");
				String mid=sc.next();
				System.out.println("Enter phone number");
				long phno=Long.parseLong(sc.next());
				
				insert.setInt(1, id);
				insert.setString(2, name);
				insert.setDouble(3, sal);
				insert.setString(4, add);
				insert.setString(5, mid);
				insert.setLong(6, phno);
				
				int k=insert.executeUpdate();
				if(k>0)
				{
					System.out.println("Employee details uploaded successfully...");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void select()
		{
			try {
				System.out.println("2. View empoylee details");
				ResultSet rs=select.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getLong(6));
					 
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void selectByStartWithName()
		{
			try {
				System.out.println("3. Retrieve employee whose name stats with 'S'.");
				ResultSet rs=selectByStartWithName.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getLong(6));
					 
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void salaryInBetween()
		{
			try {
				System.out.println("4.Retrieve employees whose salary between 10000 to 20000.");
				ResultSet rs=salaryInBetween.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getLong(6));
					 
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		public static void updateById()
		{
			try {
				System.out.println("Enter updated salary :");
				double sal=sc.nextDouble();
				System.out.println("Enter employee id");
				int id=sc.nextInt();
				updateById.setDouble(1,sal);
				updateById.setInt(2, id);
				int k=updateById.executeUpdate();
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
		public static void deleteBySal()
		{
			try {
				int k=deleteBySal.executeUpdate();
				if(k>0)
				{
					System.out.println("Deleted max salary employee");
				}
				else System.out.println("record not found");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void deleteByName()
		{
			try {
			int k=deleteByName.executeUpdate();
			if(k>0)
			{
				System.out.println("Deleted employee whose name ends with a");
			}
			else System.out.println("Record not found");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	
}
