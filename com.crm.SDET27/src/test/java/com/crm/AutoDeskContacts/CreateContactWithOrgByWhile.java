package com.crm.AutoDeskContacts;
/**
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepositary.ContactPage;
import com.crm.autodesk.ObjectRepositary.CreateContact;
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

public class CreateContactWithOrgByWhile extends BaseClass {
	@Test(groups = "regressionSuite")
	public void createontactWithOrgTest() throws Throwable, Throwable {
		
		
		
				 int randomNum = jLib.getRanDomNumber();
       
				    String orgName = eLib.getDataFromExcel("Sheet1", 1, 0)+randomNum ;
		             String contactname = eLib.getDataFromExcel("Sheet1",7, 2)+randomNum;
				
				
				
				//step 2: navigate to organisation module

				 HomePage hp = new  HomePage(driver);
		         hp.getOrganizationLink().click();
				 //step3: "click on create organisation button"
		         Organization op = new Organization(driver);
		 		op.getCreateOrgLookUpImg().click();
			    
				
				//step 4: enter all the details & create new organisation
				

			     CreateOrg co = new  CreateOrg(driver);
			        co.createOrg(orgName);
				
			         Thread.sleep(5000);
				//step 5: navigate to contact module

			    
			         hp.getContactsLink().click();
				 //step6: "click on create contact button"
				
			         ContactPage cp = new ContactPage(driver);
				        cp.getCreateContactLookUpImg().click();
				//step 7: enter all the details & create new contact
				
				        CreateContact cc = new CreateContact(driver);
				      cc.createContact(orgName, contactname, driver);				
				
				

				
				
				
				
	}

}
