import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromBase {
public static void main(String[] args) throws Throwable {
//register the database
	String expectedProjectID = "1";
	
    Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Establish the connection with database
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	
	//issue the statement 
	
	Statement statement = connection.createStatement();
	
	//execute queries
	
	ResultSet result = statement.executeQuery("select * from studentinfo");
	
	while(result.next())
	{
	
		if(result.getString(1).equals(expectedProjectID)) {
		System.out.println("passed");
	}
	}
	
	// close the database connection
	
	connection.close();
	}
}
