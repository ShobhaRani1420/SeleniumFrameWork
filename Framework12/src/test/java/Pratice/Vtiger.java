package Pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Vtiger {

	public static void main(String[] args) {
		
		String key="webdriver.gecko.driver";
	     String value="src/main/resources/geckodriver.exe";
		System.setProperty(key, value);
		WebDriver driver=(WebDriver) new  GeckoDriverInfo();
		//driver.manage().window().maximize();

	//	driver.get("");
	}

}
