package commonMain;

import org.openqa.selenium.WebDriver;

import pageLibrary.LoginPage;
import utilities.ScreenshotUtil;

/**
 * This class consists of Reference variables to hold the object of every class
 * in 'pageLibrary' and 'utilities' package. Every Reference variable is
 * encapsulated and can be called only using its "getter+setter" method. Object
 * duplication is handled using 'if' condition.
 * 
 * @author krishna.d.hegde
 *
 */
public class PageObjectRepository {
	private WebDriver driver;
	
	private LoginPage objLoginPage;
	private ScreenshotUtil objScreenshotUtil;

	public PageObjectRepository(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage objLoginPage() {
		if (objLoginPage == null) {
			objLoginPage = new LoginPage(driver);
		}
		return objLoginPage;
	}

	public ScreenshotUtil objScreenshotUtil() {
		if (objScreenshotUtil == null) {
			objScreenshotUtil = new ScreenshotUtil(driver);
		}
		return objScreenshotUtil;
	}
	
}
