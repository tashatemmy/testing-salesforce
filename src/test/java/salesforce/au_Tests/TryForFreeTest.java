package salesforce.au_Tests;

import org.testng.annotations.Test;
import salesforce.au_pageobjects.TryForFree;

public class TryForFreeTest extends Base {
	
	@Test
	public void tryTest() {
		TryForFree tfy = new TryForFree(driver);
		tfy.clickTryForFree(driver);
	
	}

}
