package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation {

	public Validation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
 /* @FindBy(css="span.dvHeaderText")
	private WebElement actualOrganizationData;
	
  //getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	//bussiness logics
	public void organisationValidation(WebDriver driver,String data)
	{
	String actData = actualOrganizationData.getText();
	
	if(actData.contains(data))
	   {
	  	 System.out.println("pass");
	   }
	   else
	   {
	  	 System.out.println("fail");
	   }
	}*/
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement validate;

	public WebElement getValidate() {
		return validate;
	}
	
	public String orgvalidate(WebDriver driver,String actData)
	{
		String data = validate.getText();
		return data;
	}
	
	
	
	
	
	
	
	
}
