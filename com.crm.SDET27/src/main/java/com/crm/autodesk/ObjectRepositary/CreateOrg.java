package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrg extends WebDriverUtility
{
//step1: create seperate  classes
//Strp2:Declaration
	@FindBy(name="accountname")
	private WebElement OrganizationNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	@FindBy(name="industry")
	private WebElement createIndustryEdt;
	@FindBy(name="accounttype")
	private WebElement createTypeEdt;
	//Step3:Initialization
	
	public CreateOrg(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	//Step4:Utilization

	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getCreateIndustryEdt() {
		return createIndustryEdt;
	}

	public WebElement getCreateTypeEdt() {
		return createTypeEdt;
	}

	
	//business library
	public void createOrg(String orgName)
	{
		OrganizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName,String industry,String Type) {
		OrganizationNameEdt.sendKeys(orgName);
		select( createIndustryEdt,industry );
		select( createTypeEdt,Type );
		saveBtn.click();
	}


}
