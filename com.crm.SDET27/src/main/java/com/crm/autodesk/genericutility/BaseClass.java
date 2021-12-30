package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepositary.HomePage;
import com.crm.autodesk.ObjectRepositary.LogInPage;

public class BaseClass {
	public WebDriver driver;
      // object creation library
	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtilty jLib = new JavaUtilty();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver sdriver;
	
	
	
	public void demo4()
	{
		
	}
	@BeforeSuite(groups = {"smokeSuite","regressionSuite"})
	public void dbConnect()
	{
		dLib.closeToDB();
		System.out.println("DB connected successfully");
	}
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeSuite","regressionSuite"})
	public void launchBrowser() throws Throwable
	
	{
		System.out.println("Launch the Browser");
		int randomNum = jLib.getRanDomNumber();
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		sdriver = driver;
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@BeforeMethod(groups = {"smokeSuite","regressionSuite"})
		public void commonData() throws Throwable
		{
		
			String username= fLib.getPropertyKeyValue("username");
			String password = fLib.getPropertyKeyValue("password");
		     
			LogInPage lp = new LogInPage(driver);
			lp.LogInPage(username, password);
			System.out.println("login successfully");
			
			
		}
	 @AfterMethod(groups = {"smokeSuite","regressionSuite"})
	 public void logOut()
	 {
		 HomePage hp = new HomePage(driver);
		  hp.logout(driver);
		  System.out.println("log out successfully");
		  }
	 @AfterClass(groups = {"smokeSuite","regressionSuite"})
		 public void closeBrowser()
		 {
			 System.out.println("browser close successfully");
			 driver.quit();
		 }
	 @AfterSuite(groups = {"smokeSuite","regressionSuite"})
	 public void closeDBConnection() {
		 dLib.closeToDB();
		 System.out.println("DB connection close successfully");
	 }
	 public void demo2()
	 {
		 
	 }
	 
	}

