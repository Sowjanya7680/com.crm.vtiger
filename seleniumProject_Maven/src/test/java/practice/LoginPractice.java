package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;
import com.crm.autodesk.elementRepository.LoginPage;

public class LoginPractice {
	
	@Test
	
	public void loginPractice() throws Throwable
	{
		WebDriver driver = null;
	
	JSONFileUtility jsonLib= new JSONFileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();

	String BROWSER = jsonLib.readDataFromJson("browser");
	String URL = jsonLib.readDataFromJson("url");
	String USERNAME= jsonLib.readDataFromJson("username");
	String PASSWORD = jsonLib.readDataFromJson("password");

	String contactname = eLib.getExcelData("Sheet 1", 1, 2);
	String orgname = eLib.getExcelData("Sheet 1", 1, 3);
	 

	//Launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}else if (BROWSER.equalsIgnoreCase("Firefox")) {
		driver= new FirefoxDriver();
	}else {
		System.out.println("Invalid Browser");
	}

	wLib.waitForPageLoad(driver);
	wLib.maximizeWindow(driver);
	driver.get(URL);
	
	LoginPage lp = new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
	System.out.println("login successful");
	}
}
