import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Salary System");
		try
		{
			String eName,eId;
        	int salary;
        	
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?characterEncoding=utf8", "root", "Reset@123");
			Statement s =c.createStatement(); 
	           System.out.println("Enter your choice");
	           System.out.println("1. View All Employee data");
	           System.out.println("2. Search Employee Data");
	           System.out.println("3. Insert new Employee Data");
	           System.out.println("4. Update existing employee data");
	           System.out.println("5. delete exe employee data");
	           Scanner sc=new Scanner(System.in);
	           int n=sc.nextInt();
	           switch (n) {
	           case 1:
	             
	             PreparedStatement ps = c.prepareStatement("select * from sys.employees");
	             ResultSet rs = ps.executeQuery();
	             while(rs.next()) {
	   			  System.out.print(rs.getInt(1)+" \t"); System.out.print(rs.getString(2)+" \t");System.out.println(rs.getInt(3)); 
	   			  }
	             break;
	           case 2:
	             
	             System.out.println("Enter the employee eName :"); 
	             eName = sc.next();
	             PreparedStatement ps1 = c.prepareStatement("select * from employees where eName=?");
	             ps1.setString(1, eName);
	             ResultSet r = ps1.executeQuery();
	             while(r.next()) {
	   			  System.out.print(r.getString(2)+" \t"); System.out.println(r.getInt(1)); 
	   			  }
	             break;
	           case 3:
	             
	             System.out.println("Enter the Employee eId :"); 
	             eId = sc.next(); 
				 System.out.println("Enter the Employee eName :"); 
				 eName = sc.next();
				 System.out.println("Enter the Employee salary : "); 
				 salary = sc.nextInt();
				 int temp = s.executeUpdate("insert into employee values('"+eId+"','"+eName+"',"+salary+")");
				 System.out.println("Insertion of employee details was successfull!!!!");
	             break;
	           case 4:
	        	   
	             
	             System.out.println("Enter the Employee eId :"); 
	             eId = sc.next(); 
				 System.out.println("Enter the Employee salary : "); 
				 salary = sc.nextInt();
	             int temp1 = s.executeUpdate("update employee set  salary="+salary+"where eId="+eId);
				 System.out.println("updation of employee details was successfull!!!!");
	             break;
	           case 5:
	             
	             System.out.println("Enter the Employee eId :"); 
	             eId = sc.next();
	             int temp2 = s.executeUpdate("delete from employee where eId="+eId);
				 System.out.println("employee details was deleted successfully!!!!");
	             


	        }
	        }
	        catch(ClassNotFoundException|SQLException e)
	        {
	            System.out.println(e);
	        }
	    
	}
	}
