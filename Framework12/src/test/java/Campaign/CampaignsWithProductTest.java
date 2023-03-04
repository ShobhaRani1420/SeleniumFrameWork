package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Property_Utility;
import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignsWithProductTest extends BaseClass{

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void campaignsWithProductTest() throws Throwable {
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
				
				//Fetching Data from property_file
						FileInputStream fis=new FileInputStream("C:\\Users\\Shobha\\Desktop\\Commondata.properties.txt");
						Properties pro=new Properties();
						pro.load(fis);
						String URL = pro.getProperty("url");
						String USERNAME = pro.getProperty("username");
						String PASSWORD = pro.getProperty("password");
						
						//Login to Vtiger Application
						driver.get(URL);
						driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
						
						driver.findElement(By.linkText("Products")).click();
						driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
						
						//RandomClass
						Random ran=new Random();
						int ranNum = ran.nextInt(1000);
						//fetching data from excel
						FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
						Workbook book=WorkbookFactory.create(fes);
						Sheet sheetname = book.getSheet("Product");
						Row rowNum = sheetname.getRow(0);
						Cell celValue = rowNum.getCell(0);
						String prdName = celValue.getStringCellValue()+ranNum;
						driver.findElement(By.name("productname")).sendKeys(prdName);
						//save
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
						driver.findElement(By.linkText("More")).click();
						driver.findElement(By.linkText("Campaigns")).click();
						
						driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
						
						FileInputStream fis1=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
						Workbook book1=WorkbookFactory.create(fis1);
						Sheet sheetName = book.getSheet("Organization");
						Row rowNum1 = sheetName.getRow(0);
						Cell cellNum1 = rowNum1.getCell(0);
						String data = cellNum1.getStringCellValue()+ranNum;
						driver.findElement(By.name("campaignname")).sendKeys(data);
						
						driver.findElement(By.xpath("//img[@alt='Select']")).click();
						
						//Swtiching window
						WebDriver_Utility wlib=new WebDriver_Utility();
						wlib.switchWindow(driver, "Products&action");
					/*	 Set<String> allId = driver.getWindowHandles();
					     Iterator<String> it=allId.iterator();//4
					     while(it.hasNext())//org,prd,ctn,lead
					     {
					     	String wid = it.next();//org
					     	driver.switchTo().window(wid);//org//prd
					        String title = driver.getTitle();
					     	if(title.contains("Products&action"))
					     	{
					     		break;
					     	}
					     }*/
					     driver.findElement(By.name("search_text")).sendKeys(prdName);
					     driver.findElement(By.xpath("//input[@name='search']")).click();
					     
					     Thread.sleep(2000);
					   //  driver.findElement(By.xpath("//a[text()='Phone848']")).click();
					     //dynamic xpath
					     driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
					      Thread.sleep(2000);
						wlib.switchWindow(driver, "Campaigns&action");
					      /*Set<String> allId1 = driver.getWindowHandles();
					     Iterator<String> it1=allId1.iterator();
					     while(it1.hasNext())
					     {
					     	String wid1 = it1.next();
					     	driver.switchTo().window(wid1);
					        String title1 = driver.getTitle();
					     	if(title1.contains("Campaigns&action"))
					     		{
					     		break;
					     	}
					     }*/
					  //   System.out.println(driver.getTitle());
					     
					     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();						     
					     
					     Thread.sleep(1000);
						 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
							driver.findElement(By.linkText("Sign Out")).click();

					     
					     

	}

}
