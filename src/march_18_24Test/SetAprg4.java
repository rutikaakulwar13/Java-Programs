package march_18_24Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetAprg4 {
	static class X
	{
		String id;
		String name;
		int price;
		int qty;
		public X(String id, String name, int price, int qty) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.qty = qty;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		@Override
		public String toString() {
			return "X [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
		}
		
	}
	ArrayList<X> list=new ArrayList<>();
	public void product()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				String id=rs.getString(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				int qty=rs.getInt(4);
				list.add(new X(id, name, price, qty));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void operations()
	{
		List<X> collect = list.stream().filter(p->p.getPrice()>1000 && p.getPrice()<5000).sorted(new Comparator<X>() {

			

			@Override
			public int compare(X o1, X o2) {
				// TODO Auto-generated method stub
				if( new StringBuffer(o1.getId()).reverse().equals(o2))
					return Integer.parseInt(o1.getId());
				return -1;
				
			}
		}).collect(Collectors.toList());
		System.out.println("__________");
		System.out.println(collect);
	}
}
