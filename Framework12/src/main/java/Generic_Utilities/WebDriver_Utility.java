package Generic_Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	/**
	 * this method is used to switch windows
	 * @param driver
	 * @param PartialWindowTitle
	 */
	public void switchWindow(WebDriver driver,String PartialWindowTitle )
	{
		 Set<String> allId = driver.getWindowHandles();
	     Iterator<String> it=allId.iterator();//4
	     while(it.hasNext())//org,prd,ctn,lead
	     {
	     	String wid = it.next();//org
	     	driver.switchTo().window(wid);//org//prd
	        String title = driver.getTitle();
	     	if(title.contains(PartialWindowTitle))
	     	{
	     		break;
	     	}
	     }
	}
	public void moveToElement(WebDriver driver, WebElement element)
	{
		 Actions act=new Actions(driver);
	     act.moveToElement(element).perform();
	}
	
	
	
	
	
	
}
