package Sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utiltiy;
import Generic_Utilities.Property_Utility;
import POM_Repo.Home_Page;
import POM_Repo.OrganizationCreatePage;

public class DemoPrgTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createOrganizationTest() throws Throwable {
	Property_Utility plib=new Property_Utility();
//		String BROWSER = plib.getKeyValue("browser");
//		
//		WebDriver driver;
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
	//Fetching Data from property_file
//	    String URL = plib.getKeyValue("url");
//		String USERNAME = plib.getKeyValue("username");
//		String PASSWORD = plib.getKeyValue("password");
//	//Login to Vtiger Application
//		driver.get(URL);
//		Login_Page login=new Login_Page(driver);
//		login.loginToApp(USERNAME, PASSWORD);
	//click on organization link
		Home_Page home=new Home_Page(driver);
		home.clickOrganization();
	//click on + img
		OrganizationCreatePage orgpage=new OrganizationCreatePage(driver);
		orgpage.clickOrganization();
	//Random Class to avoid Duplicate
		Java_Utiltiy jlib=new Java_Utiltiy();
		int ranNum = jlib.getRanDomNum();
//fetching data from Excel
		Excel_Utility elib=new Excel_Utility();
		String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
    //add excel data
		orgpage.organizationName(orgName);
 //  driver.findElement(By.name("accountname")).sendKeys(orgName);
	    //save
		orgpage.saveButton();
 //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(orgName))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		Thread.sleep(1000);
		//signout
	//	home.logout(driver);
		
	}
}
