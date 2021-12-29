package com.crm.AutoDeskContacts;
/**
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtilty;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class AutoDeskContactAndOrg {

public static void main(String[] args) throws IOException, Throwable {
	
	// create object to libraries
	JavaUtilty jLib = new JavaUtilty();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	//step 1:get the java representation object of the physical file
	
	 FileInputStream fis = new FileInputStream("./docs/Common.properties");
	 
	 //step 2: create an object to property class to load all the keys
	 
	 Properties pobj = new Properties();
	 pobj.load(fis);
	  //step 3: read the vale using getproperty("key")
	 String URL = pobj.getProperty("url");
	 String USERNAME = pobj.getProperty("username");
	 String PASSWORD = pobj.getProperty("password");
	 String BROWSER  = pobj.getProperty("browser");
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
	}
	 
	 
	//step1: login
	        driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(URL);
			//create organisation
			//read data from excel
			Random rand = new Random();
			int randNum = rand.nextInt(1000);
			
			Random rand2 = new Random();
			int randnum2 = rand.nextInt(1000);
			
			FileInputStream fis1 = new FileInputStream("./docs/Book3.xlsx");
			Workbook wb2 = WorkbookFactory.create(fis1);
			
			String contactName = wb2.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue()+randnum2;
			
			FileInputStream fis2 = new FileInputStream("./docs/Book3.xlsx");
			Workbook wb = WorkbookFactory.create(fis2);
			String orgName = wb2.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue()+randNum;
			
			
			driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
			//step 2: navigate to organisation module

			driver.findElement(By.linkText("Organizations")).click();
			 //step3: "click on create organisation button"
			
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			//step 4: enter all the details & create new organisation
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(10000);
			
			driver.findElement(By.linkText("Contacts")).click();
			 //step3: "click on create contact button"
			
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			//step 4: enter all the details & create new contact
			
			driver.findElement(By.name("lastname")).sendKeys(contactName);
						driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			
			Thread.sleep(3000);
			
			String parentid = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			for(String b:child)
			{
				driver.switchTo().window(b);
				
				
			}
			driver.findElement(By.linkText(orgName)).click();
			driver.switchTo().window(parentid);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//step 6:logout
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
			
			
			
}
}
