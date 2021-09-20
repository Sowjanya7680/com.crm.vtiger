package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB {
	
	public static void main(String[] args) throws Throwable {
		
	//Step:1 Register/load the mySql database
	
	Driver driverref = new	Driver();
	DriverManager.registerDriver(driverref);	
		
	//Step:2 Get Connect to Database
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
		
	//Step:3 Create Sql statement
	
	Statement stat = con.createStatement();
	String query = "select * from students_info";
		
	//Step:4 Execute statement/Query
	
	ResultSet result = stat.executeQuery(query);
	while (result.next()) {
		System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) +  "\t" + result.getString(4));
	}
	//Step:5 Close the connection
	con.close();
		
	}	
	}
	

