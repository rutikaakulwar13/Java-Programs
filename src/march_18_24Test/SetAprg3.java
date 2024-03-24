package march_18_24Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;

public class SetAprg3 {
	static class Employee
	{
		int id;
		String name;
		int age;
		String department;
		public Employee(int id, String name, int age, String department) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.department = department;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public boolean isPrime(int age)
		{
			int count=0;
			for(int i=2;i<age;i++)
			{
				if(age%i==0)
				{
					count=1;
				}
			}
			if(count==0)
				return true;
			else return false;
		}
		@Override
		public String toString() {
			return "employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + "]";
		}
		
	}
	ArrayList<Employee> elist=new ArrayList<SetAprg3.Employee>();
	public void emp()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM EMPLOYEES");
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				System.out.println("EId:"+rs.getInt(1));
				int id=rs.getInt(1);
				System.out.println("Name:"+rs.getString(2));
				String name=rs.getString(2);
				System.out.println("Age:"+rs.getInt(3));
				int age=rs.getInt(3);
				System.out.println("Department:"+rs.getString(4));
				String dpt=rs.getString(4);
				elist.add(new Employee(id, name, age, dpt));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void operations()
	{
	elist.stream().map(e->e.getAge()>25).filter(e->e.isPrime(e.getAge())==true)).forEach(System.out::println);
		
	} 
	}

