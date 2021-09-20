package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class contains generic methods to read and write data from Excel Sheet
 * @author Sowjanya
 *
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read the data from excel sheet wrt to row number and cell number 
	 * @throws Throwable 
	 */
	
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelsheetpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row	= sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method returns the data full in sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
		
	public Object[][] getExcelDataObject(String sheetName) throws Throwable
	{

		FileInputStream fis = new FileInputStream(IPathConstants.excelsheetpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) 
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
