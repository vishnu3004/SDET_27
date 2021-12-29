package com.crm.autodesk.ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class LogInPage extends WebDriverUtility{ //Step1: Create a seperate class 
	//Step2: identify all webElements and declare them as private
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name = "user_password")
	private  WebElement passwordEdt;

    @FindBy(id="submitButton")
    private  WebElement loginBtn;
    
    //Step3: initialize the elements using constructor
    public LogInPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
     //Step4:Utilization
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
		//Business Libraries
	public void LogInPage(String username , String password) {
	UsernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
	
	
	}
	}

