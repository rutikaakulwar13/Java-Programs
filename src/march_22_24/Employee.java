package march_22_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
	static class Emp
	{
		private int id;
		private String name;
		private int age;
		private double salary;
		public Emp(int id, String name, int age, double salary) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
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

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
	}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
		
	}
	static List<Emp> lst=null;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 lst=new ArrayList<>();
		Statement stm=null;
	
	
	
	try(sc;) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
			while(true)
			{
			System.out.println("Enter choice:");
			System.out.println("1.Create & insert\n"+"2.Rertrive"+"\n3.Operations"+"\n4.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the query ");
			String query=sc.nextLine();
		query=sc.nextLine();
						stm=con.createStatement();
			
			int k=stm.executeUpdate(query);
			System.out.println("Updated successfully");
			break;
			
			}
			case 2:
			{
				System.out.println("Enter the select query:");
				String query=sc.nextLine();
				query=sc.nextLine();
				stm=con.createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next())
				{    Employee.Emp li=new Employee.Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				//System.out.println(li);
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
					li.setId(rs.getInt(1));
					li.setName(rs.getString(2));
					li.setAge(rs.getInt(3));
					li.setSalary(rs.getInt(4));
					lst.add(li);
					//lst.add(new Emp(id, name, age, salary));
				}
				operations();
				break;
			}
			case 3:
			{System.out.println("Enter the select query:");
			String query=sc.nextLine();
			query=sc.nextLine();
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next())
			{    Employee.Emp li=new Employee.Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
			//System.out.println(li);
				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				li.setId(rs.getInt(1));
				li.setName(rs.getString(2));
				li.setAge(rs.getInt(3));
				li.setSalary(rs.getInt(4));
				lst.add(li);
				//lst.add(new Emp(id, name, age, salary));
			}
			operations();
				
				break;
			}
			case 4:
			{
				System.exit(0);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}

	
	
	  public static void operations() {
   System.out.println(lst);
	  lst.stream().filter(e->e.age>25).forEach(System.out::println);
	  System.out.println("jhhgj");
	  }
	 
	
	
}
