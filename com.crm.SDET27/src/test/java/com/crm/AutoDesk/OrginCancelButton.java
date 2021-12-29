package com.crm.AutoDesk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepositary.CreateOrg;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LogInPage;
import com.crm.autodesk.ObjectRepositary.Organization;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtilty;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrginCancelButton extends BaseClass {

	@Test
	public void createOrgCancelTest() throws Throwable {
		
		 
	
	    int randomNum = jLib.getRanDomNumber();
	    



					String orgName = eLib.getDataFromExcel("Sheet1", 1,2)+randomNum;
	
		//step 2: navigate to organisation module
		 HomePage hp = new  HomePage(driver);
         hp.getOrganizationLink().click();
		 //step3: "click on create organisation button"
		
         Organization op = new Organization(driver);
 		op.getCreateOrgLookUpImg().click();;
		
		//step 4: enter all the details & create new organisation
		

	     CreateOrg co = new  CreateOrg(driver);
	        co.createOrg(orgName);
				
	     
	}

}
