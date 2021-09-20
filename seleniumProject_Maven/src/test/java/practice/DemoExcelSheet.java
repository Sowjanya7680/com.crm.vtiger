package practice;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;

public class DemoExcelSheet {
	
	@Test
	public void demoExcelSheet() throws Throwable
	{
	
		ExcelFileUtility eLib= new ExcelFileUtility ();
		//String contactname = eLib.getExcelData("sheet1", 1, 2);
		//String orgname = eLib.getExcelData("sheet1", 1, 3);
		String orgname = eLib.getExcelData("sheet1", 5, 2);
		
		//System.out.println(contactname);
		System.out.println(orgname);
	}

}
