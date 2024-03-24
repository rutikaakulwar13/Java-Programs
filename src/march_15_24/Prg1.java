package march_15_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Prg1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println(" 1.Insert data into Employee Table.\r\n"
					+ "       2.Retrieve all Employee data.\r\n"
					+ "       3.Retrieve employee whose name stats with 'S'.\r\n"
					+ "       4.Retrieve employees whose salary between 10000 to 20000.\r\n"
					+ "       5.Update employee salary with the help of eid.\r\n"
					+ "       6.delete employee who is getting maximum salary.\r\n"
					+ "       7.delete employee whose name ends with 'a';\r\n"
					+ "       8.Exit. ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1->Employee_Info.insert();
			case 2->Employee_Info.select();
			case 3->Employee_Info.selectByStartWithName();
			case 4->Employee_Info.salaryInBetween();
			case 5->Employee_Info.updateById();
			case 6->Employee_Info.deleteBySal();
			case 7->Employee_Info.deleteByName();
			case 8->
			{
				System.out.println("Exited!!!");
				System.exit(0);
			}
			
			
			}
		}
	}
}
