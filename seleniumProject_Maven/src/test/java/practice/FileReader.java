package practice;

import com.crm.autodesk.GenericUtilities.JSONFileUtility;

public class FileReader {
	
	public static void main(String[] args) throws Throwable {
		
		JSONFileUtility jsonlib = new JSONFileUtility();
		
		String val = jsonlib.readDataFromJson("url");
		
		System.out.println(val);
		
	}


}
