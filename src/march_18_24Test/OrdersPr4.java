package march_18_24Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersPr4 {
	static class Ord{
		int oid;
		String oName;
		Date dt;
		public Ord(int oid, String oName, Date dt) {
			super();
			this.oid = oid;
			this.oName = oName;
			this.dt = dt;
		}
		public int getOid() {
			return oid;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		public String getoName() {
			return oName;
		}
		public void setoName(String oName) {
			this.oName = oName;
		}
		public Date getDt() {
			return dt;
		}
		public void setDt(Date dt) {
			this.dt = dt;
		}
		@Override
		public String toString() {
			return "ord [oid=" + oid + ", oName=" + oName + ", dt=" + dt + "]";
		}
		
	}
	ArrayList<Ord> corders=new ArrayList<>();
	public void order()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
			PreparedStatement retrive=con.prepareStatement("SELECT * FROM ORDERS");
		
			ResultSet rs=retrive.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("ORDERID");
				String name=rs.getString("ORNAME");
				Date date=rs.getDate("ORDATE");
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3));
				Ord or1=new Ord(id, name, date);
				corders.add(or1);
				
			}
			//corders.forEach(System.out::println);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void operations()
	{
		List<Ord> list = corders.stream()
                .sorted(Comparator.comparingDouble(Ord::getOid).reversed()) // Sort by price in descending order
                .limit(3) // Limit to three records
                .collect(Collectors.toList());
		  
		  list.forEach(System.out::println);
	}
}
