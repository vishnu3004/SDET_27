package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Organization {//Step1:create separate class
//Step2:Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement SearchNowBtn;
	//Step3:Initialization
	public Organization(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}
	//Step4:Utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}
	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}
}
