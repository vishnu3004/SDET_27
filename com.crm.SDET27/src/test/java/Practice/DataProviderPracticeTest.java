package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	@Test(dataProvider="getData")
	public void readDataFromDataProviderPracticeTest(String Name,int qty,int psg) {
		System.out.println("Airline name---"+Name+"----Ticket price----"+qty+"Number of Passengers"+psg);
	    
}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[5][3];
		
		objArr[0][0] = "IndianAirlines";
		objArr[0][1] = 5000;
		objArr[0][2]=30;
		
		objArr[1][0] = "IndiGo";
		objArr[1][1] = 6000;
		objArr[1][2]=40;
		
		objArr[2][0] = "AirIndia";
		objArr[2][1] =7000;
		objArr[2][2]=50;
		
		objArr [3][0] = "SpiceJet";
		 objArr[3][1] =8000;
		 objArr[3][2]=70;

		 objArr [4][0] = "Vistara";
		 objArr[4][1] =9000;
		 objArr[4][2]=80;

		 
		 
		return objArr;
		
		
		
	}
	}

