package com.crm.autodesk.GenericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

public class WebDriverUtility {
	
	
	
	/**
	 * This method will wait for the page load for 20 seconds
	 * @param driver
	 */

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method wait for element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	   /**
	    * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
	    * @param element
	    * @throws throwable
	    * 
	    */
	   
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	       
	   }

	//maximize the browser
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will select from the dropdown using visible text
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	/**
	 * This method will select from the dropdown using visible text
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	
	public void acceptsAlert(WebDriver driver)
	{
			driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch to frame wrt to 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	    * This method helps to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
	   }

	
	public void switchToWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String titleString = driver.switchTo().window(winId).getTitle();
			
		}
	}
		/**
		    * This method will perform mouse over action
		    * @param driver
		    * @param element
		    */
		public void mouseOver(WebDriver driver,WebElement element)
		   {
			   Actions act = new Actions(driver);
			   act.moveToElement(element).perform();
			   
		   }
		   
		   /**
		    * This method performs right click operation 
		    * @param driver
		    * @param element
		    */
		  public void rightClick(WebDriver driver,WebElement element)
		   {
			   Actions act = new Actions(driver);
			
			act.contextClick(element).perform();
		   }

	}
