package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class demoTest extends BaseClass {
	
	@Test
	public void demoTest() {
		System.out.println("demo");
		Assert.fail();
		
	}

}
