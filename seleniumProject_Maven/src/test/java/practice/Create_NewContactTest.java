package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

public class Create_NewContactTest {
	
	static WebDriver driver;
	@Test
	public void contactTest() {
		
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String BROWSER = System.getProperty("browserName");
		String LASTNAME = System.getProperty("lastname");
	
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equals("Firefox")) {
			driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.name("button")).click();
		driver.close();		
	}

}
