package com.rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class VerificationOfRmg {
public static void main(String[] args) throws SQLException {
	
	//login to application
	
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8084/");
	
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
	
	//creating project
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	
	driver.findElement(By.name("projectName")).sendKeys("testyantraltd");
	driver.findElement(By.name("createdBy")).sendKeys("Aadarshsir");
	WebElement projectstatus = driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	Select s = new Select(projectstatus);
	s.selectByIndex(2);
	
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	//register the data base
	String expectedProjectName = "testyantraltd";
	Driver driver1 = new Driver();
	DriverManager.registerDriver(driver1);
	
	//Establish the connection with database
	
	Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	//issue the statement 
	
	Statement statement = connection.createStatement();
	
	//execute queries
	
ResultSet result = statement.executeQuery("select * from project");
	
	while(result.next())
	{
	
		if(result.getString(4).equals(expectedProjectName)) {
		System.out.println("passed");
	}
	}
	
	// close the database connection
	
	connection.close();
}
}
