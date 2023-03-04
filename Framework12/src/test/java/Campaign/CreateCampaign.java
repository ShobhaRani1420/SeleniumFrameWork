package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaign {

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
				
	}

}
