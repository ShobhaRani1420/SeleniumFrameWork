package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class Home_Page {

public Home_Page(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(linkText="Organizations")
private WebElement organizationLink;


@FindBy(linkText="Products")
private WebElement productLink;

@FindBy(linkText="More")
private WebElement moreLink;

@FindBy(linkText="Campaigns")
private WebElement campaignsLink;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement signoutImg;

@FindBy(linkText="Sign Out")
private WebElement signoutLink;


public WebElement getOrganizationLink() {
	return organizationLink;
}

public WebElement getProductLink() {
	return productLink;
}

public WebElement getMoreLink() {
	return moreLink;
}

public WebElement getCampaignsLink() {
	return campaignsLink;
}

public WebElement getSignoutImg() {
	return signoutImg;
}

public WebElement getSignoutLink() {
	return signoutLink;
}


//Business logic FOr Organization

public void clickOrganization()
{
	organizationLink.click();
}


//Business logic for SignOut
public void logout(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.moveToElement(signoutImg).perform();
	signoutLink.click();
}

}
