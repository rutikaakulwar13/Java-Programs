package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Assignment6PreparedStatement {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
				
				PreparedStatement ps1=con.prepareStatement("Insert into STUDENT60 values(?,?,?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("Select * from STUDENT60");
				PreparedStatement ps3=con.prepareStatement("Select * from STUDENT60 where ROLLNO=?");
				PreparedStatement ps4=con.prepareStatement("Delete from STUDENT60 where ROLLNO=?");
				
				while(true)
				{
					System.out.println("*****Choice*****");
					System.out.println("\t1.Add Student Details \t2.View all students \t3.View student by rollno \t4. Delete student by roll no \t5.Exit");
					System.out.println("Enter your Choice=>");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:{
						System.out.println("Enter student roll no:");
						int rollno=sc.nextInt();
						
						System.out.println("Enter student name:");
						String name=sc.next();
						
						System.out.println("Enter student branch:");
						String branch=sc.next();
						
						System.out.println("Enter 6 sub marks");
						double totMarks=0;
						for(int i=0;i<6;i++)
						{
							System.out.println("Enter sub "+(i+1) +"marks");
							int mark=sc.nextInt();
							totMarks=totMarks+mark;
						
						}
						//System.out.println(totMarks);
						double per=(totMarks/600)*100;
						System.out.println(per);
						String grade=null;
						if(per>90)
							grade="A";
						else if(per>80)
							grade="B";
						else if(per>60)
							grade="C"; 
						else if(per>45)
							grade="D";
						else if(per>35)
							grade="E" ;
						else grade="fail";
						ps1.setInt(1, rollno);
						ps1.setString(2, name);
						ps1.setString(3, branch);
						ps1.setDouble(4, totMarks);
						ps1.setDouble(5,per);
						ps1.setString(6, grade);
						
						int k=ps1.executeUpdate();
						
						if(k>0)
						{
							System.out.println("Student details uploaded..");
						}
						else System.out.println("not uploaded..");
						break;
					}
					case 2:
					{
						System.out.println("View stsudent details");
						ResultSet rs=ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDouble(5)+"\t"+rs.getString(6));
						}
						
						break;
					}
					case 3:
					{
						System.out.println("View Student details by Roll no");
						System.out.println("__________________________");
						System.out.println("Enter the roll no code to view the details");
						int roll=sc.nextInt();
						ps3.setInt(1,roll);
						ResultSet rs1=ps3.executeQuery();
						if(rs1.next())
						{
							System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getDouble(4)+"\t"+rs1.getDouble(5)+"\t"+rs1.getString(6));
						}
						else System.out.println("Invalid code");
						break;
					}
					case 4:System.out.println("Delete student details by roll no:");
					System.out.println("Enter the roll no of student to be deleted...");
					int roll=sc.nextInt();
					ps4.setInt(1, roll);
					int k=ps4.executeUpdate();
					if(k>0)
					{
						System.out.println("Deleted successfully...");
					}
					else System.out.println("Invalid code...");
				
				case 5:{
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
