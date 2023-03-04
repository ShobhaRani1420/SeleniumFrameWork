package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utiltiy;
import Generic_Utilities.Property_Utility;
import POM_Repo.Home_Page;
import POM_Repo.OrganizationCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass {

@Test(groups = "RegressionTest")
	public void CreateProductTest() throws Throwable {
		//Launching the browser
		/*Property_Utility plib=new Property_Utility();
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
		}*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
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
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Products']")).click();
			//driver.findElement(By.linkText("Products")).click();
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
				
				String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();

				if(actData.contains(prdName))
				{
					 System.out.println("pass");
				}
				else
				{
					 System.out.println("fail");
				}
				
				
				
				//logout
			/*	Thread.sleep(1000);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.linkText("Sign Out")).click();*/
	}


}