import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDatabase {
public static void main(String[] args) throws Throwable {
//register the database
	
	
    Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Establish the connection with database
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	
	//issue the statement 
	
	Statement statement = connection.createStatement();
	
	//execute queries
	int result = statement.executeUpdate("insert into studentinfo(fname, lname , address) value('manoj','kumar','india')");

      // verification
	if(result==1)
	{
		System.out.println("one set of data added to database");
	}
	else
	{
		System.out.println("Data is not added to database");
		
	}
	// close the database connection
	connection.close();
}
}
