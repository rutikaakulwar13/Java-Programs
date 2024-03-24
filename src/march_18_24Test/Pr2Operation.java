package march_18_24Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pr2Operation {
	
	ArrayList<X> al=new ArrayList<>();
	class X
	{
		private int id;
		private String name;
		private int age;
		public X(int id, String name, int age) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
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
		@Override
		public String toString() {
			return "X [id=" + id + ", name=" + name + ", age=" + age + "]";
		}
		
	}
	public void operation()
   {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger");
		PreparedStatement ps1=con.prepareStatement("SELECT * FROM STUDENT1");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			int id=rs.getInt(1);
			String name=rs.getString(2);
			int age=rs.getInt(3);
			 X x=new X(id, name, age);
			al.add(x);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	al.stream().filter(e->new StringBuffer(e.getName()).reverse().equals(e.getName())).forEach(System.out::println);;
	System.out.println("_______________");
	al.stream().filter(e->new StringBuffer(e.getAge()).reverse().toString().equals(e.getAge())).forEach(System.out::println);
}

}
