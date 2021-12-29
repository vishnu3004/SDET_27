package com.crm.AutoDesk;
/**
 * @author DELL
 */
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepositary.CreateOrg;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LogInPage;
import com.crm.autodesk.ObjectRepositary.OrgInfo;
import com.crm.autodesk.ObjectRepositary.Organization;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtilty;
import com.crm.autodesk.genericutility.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass{

	@Test(groups = "smokeSuite")
	public void createOrgTest() throws Throwable {
		
		 
	
	    int randomNum = jLib.getRanDomNumber();
	    
 //read the data from Excel File
		 
		
		String orgName = eLib.getDataFromExcel("Sheet1", 1,2)+randomNum;
		
		//step 2: navigate to organisation module
         HomePage hp = new  HomePage(driver);
         hp.getOrganizationLink().click();
		
		 //step3: "click on create organisation button"
		
		Organization op = new Organization(driver);
		op.getCreateOrgLookUpImg().click();
		
		//step 4: enter all the details & create new organisation
		
	     CreateOrg co = new  CreateOrg(driver);
	        co.createOrg(orgName);
	        Assert.fail();
		//step 5: verify the organisation name in header of the msg
		OrgInfo oi = new OrgInfo(driver);
		String actualresult=oi.getOrgHeaderText();
		//Assert.assertTrue(actualresult.contains(orgName));
		System.out.println("organisation created successfully");
		
	}
 
	

}
