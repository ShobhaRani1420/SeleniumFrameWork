package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldColour {

	public static void main(String[] args) {
	
		//Launching Browser
				String key="webdriver.chrome.driver";
			     String value="src/main/resources/chromedriver.exe";
				System.setProperty(key, value);
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
		
				driver.get("https://www.facebook.com/");
				WebElement email = driver.findElement(By.name("email"));
				WebElement password = driver.findElement(By.name("pass"));
				String EMAIL = email.getCssValue("color");
				String PASSWORD = password.getCssValue("color");
				System.out.println(EMAIL);
				System.out.println(PASSWORD);
	}

}
