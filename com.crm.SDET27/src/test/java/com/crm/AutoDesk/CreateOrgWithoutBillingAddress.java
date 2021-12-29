package com.crm.AutoDesk;
/**
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LogInPage;
import com.crm.autodesk.ObjectRepositary.Organization;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtilty;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrgWithoutBillingAddress {

	public static void main(String[] args) throws Throwable {
		// create object to libraries
				JavaUtilty jLib = new JavaUtilty();
				ExcelUtility eLib = new ExcelUtility();
				FileUtility fLib = new FileUtility();
			    WebDriverUtility wLib = new WebDriverUtility();
				 //getRanDom Num
				 
				 int randomNum = jLib.getRanDomNumber();
				 
				
				//read common data from Properties File
				 

				 String URL = fLib.getPropertyKeyValue("url");
				 String USERNAME = fLib.getPropertyKeyValue("username");
				 String PASSWORD = fLib.getPropertyKeyValue("password");
				 String BROWSER = fLib.getPropertyKeyValue("browser");
				 System.out.println(BROWSER);
				 
		
				
			WebDriver driver;
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			
			}
			
			else if (BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
			
			}
			
			else
			{
				driver = new ChromeDriver();
			}wLib.waitForPageToLoad(driver);
			driver.get(URL);

			 //step1: login
			LogInPage lp = new LogInPage(driver);
			lp.LogInPage(USERNAME, PASSWORD);
			//step 2: navigate to organisation module

			 HomePage hp = new  HomePage(driver);
	         hp.getOrganizationLink().click();
			 //step3: "click on create organisation button"
			
	     	Organization op = new Organization(driver);
			op.getCreateOrgLookUpImg().click();
			
			//step 4: enter all the details & create new organisation
			
			driver.findElement(By.name("accountname")).sendKeys("AshokLeyoland");
			
			driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.testyantra.com");
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8977564714");
			driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("completed");
			
			driver.findElement(By.xpath("//input[@name='otherphone']")).sendKeys("8975755791");
			driver.findElement(By.id("employees")).sendKeys("2");
			driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("email2")).sendKeys("def@gmail.com");
			WebElement Industry = driver.findElement(By.xpath("//select[@name='industry']"));
			Select s1 = new Select(Industry);
			s1.selectByVisibleText("Chemicals");
			
			WebElement Type = driver.findElement(By.xpath("//select[@name='accounttype']"));
			Select s2 = new Select(Type);
			s2.selectByVisibleText("Investor");
			driver.findElement(By.xpath("//input[@onclick='return copyAddressLeft(EditView)']")).click();
			
			driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("near total mall");
			driver.findElement(By.xpath("//input[@id='ship_pobox']")).sendKeys("Domlur");
			driver.findElement(By.xpath("//input[@id='ship_city']")).sendKeys("Banglore");
			driver.findElement(By.xpath("//input[@id='ship_state']")).sendKeys("karnataka");
			driver.findElement(By.xpath("//input[@id='ship_country']")).sendKeys("India");
		
			
		//	wLib.mouseOverOnElemnet(driver, (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"))));
		//	driver.findElement(By.linkText("Sign Out")).click();
		//	driver.quit();

	}

}
