package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContact extends WebDriverUtility{//Step1:create seperate class
	//Step2:Declaration
	WebDriver driver;
	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
         private WebElement saveBtn;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrgLookUp;

	
	//Step3:Initialization
	
		public CreateContact(WebDriver driver) {
		PageFactory.initElements(driver, this);

		}
     //Step4:Declaration
		public WebElement getContactNameEdt() {
			return ContactNameEdt;
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void createContact(String contactname)
		{
			ContactNameEdt.sendKeys(contactname);
			saveBtn.click();
		}
		public WebElement getCreateOrgLookUpImg() {
			return OrgLookUp;
		}
		//business library
		
		public void createContact(String orgName,String contactname,WebDriver driver)
		{
			ContactNameEdt.sendKeys(contactname);
			OrgLookUp.click();
			swithToWindow(driver,"Accounts");
			driver.findElement(By.linkText(orgName)).click();
			swithToWindow(driver,"Contacts");
			saveBtn.click();
		}
		
}
