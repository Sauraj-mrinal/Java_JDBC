package using_preparStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class denmoJDBC {

	public static void main(String[] args) {
		
		
		try {
			         // step 1 : load and register Driver class 
			   Class c = Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver class loaded");
			
			        //setp 2:Establish connection with DB
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Mmhapu@800");
			
			         // STEP 3:- create statement or preparStatement
			
			    Statement stmt = con.createStatement();
			
			    System.out.println("Enter details of Students");
				Scanner scn  = new Scanner(System.in);
				System.out.println("enter ID of student");
				int id = scn.nextInt();
				System.out.println("Enter Last Name of student ");
				String Lname = scn.next();
				System.out.println("Enter is First Name of Student ");
				String Fname = scn.next();
				
				System.out.println("enter City");
				
				String city = scn.next();
				System.out.println("enter Address ");
				String add = scn.next();
				
				PreparedStatement ptr = con.prepareStatement("insert into Persons values(?,?,?,?,?)");
				ptr.setInt(1, id);
				ptr.setString(2, Lname);
				ptr.setString(3, Fname);
				ptr.setString(4, add);
				ptr.setString(5, city);
				long i = ptr.executeLargeUpdate();
				
				
				
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		

	}

}
