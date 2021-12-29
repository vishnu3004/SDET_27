package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage { //Step1:create seperate classes
//Step2:Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement SearchNowBtn;
	
	//Step3:Initialization
		public ContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
		//Step4:Utilization
		public WebElement getCreateContactLookUpImg() {
			return CreateContactLookUpImg;
		}
		public WebElement getSearchTextEdt() {
			return searchTextEdt;
		}
		public WebElement getSearchNowBtn() {
			return SearchNowBtn;
		}
		
		
	
	
}
