package com.crm.AutoDesk;
/**
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class CreateOrgWithIndustryAndType extends BaseClass {

	@Test(groups = "regressionSuite")
	public void createOrgWithIndusTest() throws Throwable{
				 
				 int randomNum = jLib.getRanDomNumber();
				 
				
		 

				 //read the data from Excel File
				 
				
				String orgName = eLib.getDataFromExcel("Sheet1", 1,2)+randomNum;
				
				String indname = eLib.getDataFromExcel("Sheet1", 4,3);
				
				
				String Typename = eLib.getDataFromExcel("Sheet1", 4,4);
				
				
		 

		//step 2: navigate to organisation module

		 HomePage hp = new  HomePage(driver);
         hp.getOrganizationLink().click();
		
		 //step3: "click on create organisation button"
		
     	Organization op = new Organization(driver);
		op.getCreateOrgLookUpImg().click();
		
		//step 4: enter all the details & create new organisation
		
		 CreateOrg co = new  CreateOrg(driver);
	      
		
		
		
		co.createOrg(orgName, indname, Typename);
	      
		
		OrgInfo oi = new OrgInfo(driver);
		String industry = oi.getIndTextInfo();
		
		SoftAssert sa = new SoftAssert();
		System.out.println(industry);
		sa.assertTrue(industry.equals(indname));
		
		String type =	oi.getTypeTextInfo();
		System.out.println(type);
		Assert.assertTrue(type.equals(Typename));
		
		sa.assertAll();
		
	        	

	}

}
