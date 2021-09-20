package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.mysql.cj.jdbc.Driver;

public class Select_Fifth_Checkbox {
	

	WebDriver driver = null;
	@Test
	public void selectFifthCheckbox() throws Throwable {
		
		JSONFileUtility jsonlib = new JSONFileUtility();
		
	//fetch the common data from external resource
		String BROWSER =jsonlib.readDataFromJson("browser");
		String URL =jsonlib.readDataFromJson("url");
		String USERNAME =jsonlib.readDataFromJson("username");
		String PASSWORD =jsonlib.readDataFromJson("password");
		
	//choose the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new OperaDriver();
		}
	//load the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
	//login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//click on organization
		driver.findElement(By.linkText("Organizations")).click();
	
	//select the fifth checkbox	
		driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[5]")).click();
	
	//close the browser
		driver.close();
}
}