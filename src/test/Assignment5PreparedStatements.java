package test;

import java.sql.*;
import java.util.Scanner;

public class Assignment5PreparedStatements {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				
				PreparedStatement ps1=con.prepareStatement("Insert into BOOKDETAILS60 values(?,?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("Select * from BOOKDETAILS60");
				PreparedStatement ps3=con.prepareStatement("Select * from BOOKDETAILS60 where CODE=?");
				PreparedStatement ps4=con.prepareStatement("Update BOOKDETAILS60 set PRICE=?,QTY=? where CODE=?");
				PreparedStatement ps5=con.prepareStatement("delete from BOOKDETAILS60 where CODE=?");
				
				while(true)
				{
					
					System.out.println("*****CHOICE*****");
					System.out.println("\t1.Add Book Details"
					+"\t2.View all book details"
							+"\t3.View book details by code"
					+"\t4.Update book details bassed on code"
							+"\t5.Delete details by code."+"\t6.Exit...");
					System.out.println("Enter your choice");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
					{
						System.out.println("=====Book Details=====");
						System.out.println("Enter book code:");
						int code=sc.nextInt();
						System.out.println("Enter book name:");
						String name=sc.nextLine();
						sc.nextLine();
						System.out.println("Enter Author name:");
						String author=sc.nextLine();
						System.out.println("Enter Price");
						double price=Double.parseDouble(sc.nextLine());
						System.out.println("Enter quantity:");
						int qty=sc.nextInt();
						
						ps1.setInt(1, code);
						ps1.setString(2, name);
						ps1.setString(3, author);
						ps1.setDouble(4, price);
						ps1.setInt(5, qty);
						int k=ps1.executeUpdate();
						if(k>0) {
							System.out.println("Book details inserted");
						}
						break;
					}
					case 2:{
						System.out.println("View book details");
						ResultSet rs=ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getInt(5));
						}
						
						break;
					}
					case 3:
					{
						System.out.println("View book details by code");
						System.out.println("__________________________");
						System.out.println("Enter the product code to view the details");
						int pC=sc.nextInt();
						ps3.setInt(1,pC);
						ResultSet rs1=ps3.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getDouble(4)+"\t"+rs1.getInt(5));
						}
						else System.out.println("Invalid code");
						break;
					}
					case 4:
					{
						System.out.println("Update book details");
						System.out.println("Enter Book price:");
						double price=sc.nextDouble();
						ps4.setDouble(1, price);
						
						System.out.println("Enter Book Quantiy:");
						int qty=sc.nextInt();
						ps4.setInt(2, qty);
						
						System.out.println("Enter product code");
						int pC=sc.nextInt();
						ps4.setInt(3, pC);
						
						int k=ps4.executeUpdate();
						if(k>0)
						{
							System.out.println("Updated successfully");
						}
						else System.out.println("Invalid code");
					}
					case 5:{
						System.out.println("Delete book details:");
						System.out.println("Enter the code of book to be deleted...");
						int pCode=sc.nextInt();
						ps5.setInt(1, pCode);
						int k=ps5.executeUpdate();
						if(k>0)
						{
							System.out.println("Deleted successfully...");
						}
						else System.out.println("Invalid code...");
					}
					case 6:{
						System.out.println("Exited");
						System.exit(0);
					}
					default: System.out.println("Invalid choice");
				}
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
;