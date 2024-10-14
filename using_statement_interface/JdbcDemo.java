package using_statement_interface;
import java.sql.*;
import java.util.Scanner;

//import com.mysql.cj.jdbc.Driver;
public class JdbcDemo {
 public static void main(String[] args) {
	// load and register driver 
	 try {
		Class c = Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class is loaded!!!");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Mmhapu@800");
		System.out.println("connection stablish!!!");
		
		
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
		
		long i = stmt.executeUpdate("insert into Persons values("+id+",'"+Lname+"','"+Fname+"','"+add+"','"+city+"')");
		if(i>0)
		System.out.println("inserted !! oky ");
		else
		System.out.println("somthing went wrong ....");
		
//		 now if i want to retrive my data from database then 
		ResultSet r = stmt.executeQuery("select * from Persons");
		while(r.next()) {
			System.out.println(r.getInt("PersonID"));
			System.out.println(r.getString("LastName"));
			System.out.println(r.getString("FirstName"));
			System.out.println(r.getString("Address"));
			System.out.println(r.getString("City"));
			
			System.out.println("-------------------------");
			System.out.println("-------------------------");
			
			
		}
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
