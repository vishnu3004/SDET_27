package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@Test(dataProvider="getData")
public void readDataFromDataProviderTest(String Name,int qty) {
	System.out.println("Movie name---"+Name+"----Mobile Quantity----"+qty);
    
}

@DataProvider
public Object[][] getData()
{
	Object[][] objArr = new Object[3][2];
	
	objArr[0][0] = "Iphone";
	objArr[0][1] = 10;
	
	
	objArr[1][0] = "Oppo";
	objArr[1][1] = 20;
	
	objArr[2][0] = "Oneplus";
	objArr[2][1] =30;
	
	return objArr;
	
}
}
