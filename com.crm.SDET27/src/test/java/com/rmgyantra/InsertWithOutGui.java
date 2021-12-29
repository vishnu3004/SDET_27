package com.rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertWithOutGui {
public static void main(String[] args) throws Throwable {
//register the database
	
	
    Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Establish the connection with database
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	
	//issue the statement 
	
	Statement statement = connection.createStatement();
	
	//execute queries
//	int res = statement.executeUpdate("insert into project( project_id,created_by,created_on,project_name,status,team_size) value('TY_PROJ_007','manohar','16/12/2021','rmgyantra','completed',0)");
      String actualName = "rmgyantra";
	ResultSet result = statement.executeQuery("select * from project");
	while(result.next())
	{
		if(result.getString(4).equals(actualName))
			
		{
			System.out.println("passed");
		}
	}
	
	
	
	// close the database connection
	
	connection.close();
	}
}
	


