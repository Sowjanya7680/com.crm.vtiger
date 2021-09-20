package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains generic methods to read data from property file
 * @author Sowjanya
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method reads data from property file
	 * @throws Throwable 
	 */
	
	public String getPropertyFileData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value= pobj.getProperty(key);
		return value;
	}

}
