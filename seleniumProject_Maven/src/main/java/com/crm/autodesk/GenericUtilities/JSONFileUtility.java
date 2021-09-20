package com.crm.autodesk.GenericUtilities;

import java.io.FileReader;
import java.util.HashMap;
/**
 * this class contains methods to read data from json file
 * @author Sowjanya
 */

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	/**
	 * this method reads the data from json file
	 * @throws Throwable
	 */
	
	public String readDataFromJson(String key) throws Throwable
	{
		//read the data from json file
		FileReader file = new FileReader("./commonData.json");
		
		//convert the json file into java object
		JSONParser jsonobJ = new JSONParser();
		Object jObj =jsonobJ.parse(file);
		
		//type cast java obj to hashmap
		HashMap map =(HashMap)jObj;
		String value = map.get(key).toString();
		
		//return the value
		return value;
		
	}

}
