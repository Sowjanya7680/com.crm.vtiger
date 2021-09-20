package practice;





import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lenskart {
	
	public static void main(String[] args) {
	WebDriver driver;	
	driver = new ChromeDriver();
	driver.get("https://www.lenskart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	List<WebElement> allList  = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
	
	int count=0;
	for(WebElement i: allList)
	{
		System.out.println(i.getText());
		count++;
	}
	
	driver.close();
}
}