package march_17_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Employee {
	static Connection con=null;
	static PreparedStatement insert=null;
	static PreparedStatement retrive=null;
	static Scanner sc=new Scanner(System.in);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			insert=con.prepareStatement("Insert into EMPLOYEE_INFO values(?,?,?,?,?,?)");
			retrive=con.prepareStatement("Select * from EMPLOYEE_INFO");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	static class EmployeeInfo
	{
		int id;
		String name;
		Double salary;
		String address;
		String mail;
		Long phone;
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
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public Long getPhone() {
			return phone;
		}
		public void setPhone(Long phone) {
			this.phone = phone;
		}
		
		public EmployeeInfo(int id, String name, Double salary, String address, String mail, Long phone) {
			super();
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.address = address;
			this.mail = mail;
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "EmployeeInfo [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address
					+ ", mail=" + mail + ", phone=" + phone + "]";
		}
		
	}
	static ArrayList<EmployeeInfo> empdetail=new ArrayList<Employee.EmployeeInfo>();
	public void insert() {
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
	
	
	public static void retrive()
	{
		try {
			ResultSet rs=retrive.executeQuery();
			while(rs.next())
			{
				EmployeeInfo emp=new EmployeeInfo(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getLong(6));
				int empId = rs.getInt("EMPID");
	            String empName = rs.getString("EMPNAME");
	            double empSal = rs.getDouble("EMPSALARY");
	            String empAddress = rs.getString("EMPADDRESS");
	            Long empPhNo = rs.getLong("EMPPHNO");

				empdetail.add(emp);
			}
			empdetail.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void operations()
	{
		System.out.println("1.sort emmployee data in descending order..");
		empdetail.stream().sorted(new Comparator<EmployeeInfo>() {

			@Override
			public int compare(EmployeeInfo o1, EmployeeInfo o2) {
				
				return (int) (o1.getSalary()-o2.getSalary());
			}

			
		}).forEach(System.out::println);
		System.out.println("________________________________");
		System.out.println("1.sort emmployee data in ascending order..");
		empdetail.stream().sorted(new Comparator<EmployeeInfo>() {

			@Override
			public int compare(EmployeeInfo o1, EmployeeInfo o2) {
				
				return (int) (o2.getSalary()-o1.getSalary());
			}

			
		}).forEach(System.out::println);
		System.out.println("________________________________________");
		System.out.println("Find those employee whose name stats with 'S'");
		empdetail.stream().filter(e->e.getName().startsWith("A")).forEach(System.out::println);
		System.out.println("________________________________________");
		System.out.println("employee whose salary is less than 20000 \r\n");
		empdetail.stream().filter(e->(e.getSalary()<20000)).forEach(System.out::println);
		System.out.println("________________________________________");
		System.out.println("________________________________________");
		System.out.println("Increase 10% salary of those employee whose salary is less than 20000 \r\n");
//		empdetail.stream().map(e->e.getSalary()).forEach(System.out::println);
//		System.out.println("___________________________________");
		List<EmployeeInfo> collect = empdetail.stream().filter(e->(e.getSalary()<20000)).collect(Collectors.toList());
		collect.forEach(e->e.setSalary(e.getSalary()+((e.getSalary()*10)/100)));
		empdetail.stream().map(e->e.getSalary()).forEach(System.out::println);
		System.out.println("___________________________________");
		//System.out.println("________________________________________");
		int count=(int) empdetail.stream().count();
		System.out.println(count);
	}
	
	}
	
	

