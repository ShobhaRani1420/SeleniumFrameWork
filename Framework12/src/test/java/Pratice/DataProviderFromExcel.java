package Pratice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderFromExcel {

	@Test(dataProvider = "getData")
	public void companyDetails(String name,String phoneNum,String Email) throws Throwable
	{
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
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(name);
			driver.findElement(By.id("phone")).sendKeys(phoneNum);
			driver.findElement(By.id("email1")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/
		driver.quit();
		Thread.sleep(2000);
}
@DataProvider
	
	public Object[][] getData() throws Throwable
	{
		FileInputStream fis1=new FileInputStream("src/test/resources/ExcelFeb.xlsx");
        Workbook book=WorkbookFactory.create(fis1);
       
        Sheet sheet = book.getSheet("DataProvider");
      int numrow = sheet.getPhysicalNumberOfRows();//num of rows
      int numcel = sheet.getRow(0).getLastCellNum();
      
     /* String[][] data=new String[numrow-1][numcel];
      for(int i=0;i<numrow;i++)
      {
    	  for(int j=0;j<numcel;j++)
    	  {
    		  DataFormatter format=new DataFormatter();
    		  data[i][j]=format.formatCellValue(sheet.getRow(i+1).getCell(j));
    	  }
      }
      
		return data;*/
      
      
		Object[][] obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}                   //0+1
		}
		return obj ;
	}


}