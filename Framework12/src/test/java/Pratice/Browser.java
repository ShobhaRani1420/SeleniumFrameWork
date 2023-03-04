package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Browser {

	public static void main(String[] args) throws Throwable {
		
		//Launching Browser
		String key="webdriver.chrome.driver";
	     String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
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
		
		//click on organization link
		driver.findElement(By.linkText("Organizations")).click();
		//click on + img
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//Random Class to avoid Duplicate
	    Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		//fetching data from Excel
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheetName = book.getSheet("Organization");
		Row rowNum = sheetName.getRow(0);
		Cell cellNum = rowNum.getCell(0);
		String orgName = cellNum.getStringCellValue()+ranNum;
		//add excel data
	   driver.findElement(By.name("accountname")).sendKeys(orgName);
	    //save
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
}

}
