package epic1;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonMain.PageObjectRepository;
import commonTest.RetryAnalyzer;
import commonTest.TestBase;
import pageLibrary.LoginPage;
import utilities.StringConstants;

/**
 * 
 * @author krishna.d.hegde
 *
 */
public class LoginPageTest extends TestBase {

	@Test
	public void testing() throws Exception {
		System.out.println("success1");
		setResultDescription("Passed successfully!");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testingNew() throws Exception {
		int i = 9 / 0;
		System.out.println("success2");
	}

}
