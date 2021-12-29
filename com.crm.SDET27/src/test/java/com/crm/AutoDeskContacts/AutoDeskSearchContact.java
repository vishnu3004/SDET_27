package com.crm.AutoDeskContacts;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepositary.ContactInfo;
import com.crm.autodesk.ObjectRepositary.ContactPage;
import com.crm.autodesk.ObjectRepositary.CreateContact;
import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LogInPage;
import com.crm.autodesk.ObjectRepositary.Organization;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtilty;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class AutoDeskSearchContact extends BaseClass{

	@Test
	public void createontactTest() throws Throwable, Throwable {
		
		
		
				 int randomNum = jLib.getRanDomNumber();
				 
		
				 //read the data from Excel File
				 
				
				 String contactname = eLib.getDataFromExcel("tc_", 1,2)+randomNum;
				
		


		//step 2: navigate to contact module

		   HomePage hp = new  HomePage(driver);
	         hp.getContactsLink().click();
		 //step3: "click on create contact button"
	        ContactPage cp = new ContactPage(driver);
	        cp.getCreateContactLookUpImg().click();
	        
	        CreateContact cc = new CreateContact(driver);
	        cc.createContact(contactname);
	        
	 	
		
		//step 5: verify the contact name in header of the msg
		ContactInfo ci = new ContactInfo(driver);
		String actualsuc_msg = ci.getContactHeaderText().getText();
		
		Assert.assertTrue(actualsuc_msg.contains(contactname));
		System.out.println("contact created successfully");
		
				}

}
