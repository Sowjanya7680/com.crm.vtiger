package com.crm.autodesk.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();

	public static WebDriver staticdriver;
	public WebDriver driver;

	@BeforeSuite(groups = { "SmokeSuites", "RegressionSuites" })
	public void connectDB() {
		System.out.println("======MakeDBConnection======");
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeSuites", "RegressionSuites" })
	public void launchBrowser() throws Throwable {
		System.out.println("=======launchBrowser=======");
		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");

		// Launch the Browser

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		staticdriver = driver;

	}

	@BeforeMethod(groups = { "SmokeSuites", "RegressionSuites" })
	public void logintoApp() throws Throwable {
		System.out.println("======loginToApp======");
		String USERNAME = jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");

		LoginPage lP = new LoginPage(driver);
		lP.login(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "SmokeSuites", "RegressionSuites" })
	public void logoutFromApp() {
		System.out.println("====logoutfromApp=====");
		HomePage hp = new HomePage(driver);
		hp.signOut();

	}

	@AfterClass(groups = { "SmokeSuites", "RegressionSuites" })
	public void closeBrowser() {
		System.out.println("=====closeBrowser======");
		driver.close();
	}

	@AfterSuite(groups = { "SmokeSuites", "RegressionSuites" })
	public void closeDB() {
		System.out.println("====closeDB====");
	}

	public String getScreenShot(String name) throws IOException {

		File srcfile = ((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir") + "/Screenshots/" + name + ".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);

		return destfile;
	}

}
