package seleniumProject_Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MySQL_DB2_Non_Select_try_catch {
	
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		
		try {

			//Step:1 Register/load the mySql database
			
			Driver driverref = new	Driver();
			DriverManager.registerDriver(driverref);	
				
			//Step:2 Get Connect to Database
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
			//Step:3 Create Sql statement
			
			Statement stat = con.createStatement();
			String query = "insert into students_info (regno, firstname, middlename, lastname) values('8', 'Abhishek','Singh', 'Abhi');";
			
			//Step:4 Execute statement/Query
			int result = stat.executeUpdate(query);
			if(result==1) {
				System.out.println("User is Created");
				}
			}catch (Exception e) {
				System.err.println("User is not Created Fail");
			}
			finally {
				//Step:5 Close the connection
				con.close();
			
		}
		
		
	}

}

