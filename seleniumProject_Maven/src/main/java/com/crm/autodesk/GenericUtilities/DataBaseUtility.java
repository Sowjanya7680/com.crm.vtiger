package com.crm.autodesk.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.collections4.functors.WhileClosure;

import com.mysql.cj.jdbc.Driver;

/** 
 * This class contains generic methods to read data from Database
 * @author Sowjanya
 *
 */

public class DataBaseUtility { 
	
	Connection con = null;
	Driver driverRef;
	/**
	 * Connection with database is established
	 * @throws Throwable 
	 */
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
	}
	/**
	 * DB connection is closed
	 * @throws Throwable  
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		String value = null;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		
		{
			value = result.getString(Columnindex);
		}
		
		return value;
	}

}
