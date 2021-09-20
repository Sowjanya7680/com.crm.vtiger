package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMI {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 15000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='See more']")).click();
		driver.findElement(By.xpath("//li[@aria-label='MI']//label/i")).click();
		String exp = driver.findElement(By.xpath(
				"(//div[contains(@class,'s-e')]//div[@class='sg-row'][2]//span[@aria-hidden='true']/span[2])[1]"))
				.getText();

	}
}
