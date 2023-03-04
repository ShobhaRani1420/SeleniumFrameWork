package Generic_Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public WebDriver driver;
public static WebDriver sdriver;
public Property_Utility plib=new Property_Utility();
 @BeforeSuite
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	//@BeforeTest
 @BeforeTest
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void BC() throws Throwable
	{
		//public void BC(String BROWSER) throws Throwable {
		
		String BROWSER = plib.getKeyValue("browser");
		
//		WebDriver driver;
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
		System.out.println("Launching Browser");
	sdriver=driver;
	}
	@BeforeMethod
	public void BM() throws Throwable
	{
		//Property_Utility plib=new Property_Utility();
		 String URL = plib.getKeyValue("url");
			String USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");
		//Login to Vtiger Application
			driver.get(URL);
			Login_Page login=new Login_Page(driver);
			login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	}
	@AfterMethod
	public void AM()
	{
		Home_Page home=new Home_Page(driver);
		home.logout(driver);
		System.out.println("Logout Application");
	}
	@AfterClass
	public void AC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	@AfterSuite
	public void AS()
	{
		
		System.out.println("DataBase Closed");
	}
}
