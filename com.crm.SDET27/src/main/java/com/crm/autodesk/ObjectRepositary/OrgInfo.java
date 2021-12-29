package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfo {//Step1:Create seperate classes
	//Step2:Declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	@FindBy(id="mouseArea_Industry")
	private WebElement indTextInfo;
	
	@FindBy(id="mouseArea_Type")
	private WebElement TypeTextInfo;

	//Step3:intialization
     public  OrgInfo(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }

	public String getOrgHeaderText() {
		return (orgHeaderText.getText());
	}
	
	public String getIndTextInfo() {
		return (indTextInfo.getText());
	}

	public String getTypeTextInfo() {
		return (TypeTextInfo.getText());
	}
	


}
