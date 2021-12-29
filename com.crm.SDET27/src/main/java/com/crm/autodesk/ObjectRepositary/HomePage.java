package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{//Step1: Create a separate class 
	WebDriver driver;
	

	//Step2: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppurtunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleticketsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//Step3:Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step4:Utilization

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOppurtunitiesLink() {
		return oppurtunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleticketsLink() {
		return troubleticketsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logout(WebDriver driver)
	{
		mouseOverOnElemnet(driver, administratorImg);
		
		signOutLink.click();
	}
}
