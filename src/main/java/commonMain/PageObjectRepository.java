package commonMain;

import org.openqa.selenium.WebDriver;

import pageLibrary.LoginPage;
import utilities.ReportUtil;
import utilities.ScreenshotUtil;

public class PageObjectRepository {
	WebDriver driver;
	//private static ReportUtil objReportUtil;
	private static LoginPage objLoginPage;
	private static ScreenshotUtil objScreenshotUtil;
	public PageObjectRepository(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage objLoginPage() {
		if (objLoginPage==null) {
			objLoginPage = new LoginPage(driver);
		}
		return objLoginPage;
	}
	
//	public ReportUtil objReportUtil() {
//		if (objReportUtil==null) {
//			objReportUtil = new ReportUtil(driver);
//		}
//		return objReportUtil;
//	}
	
	public ScreenshotUtil objScreenshotUtil() {
		if (objScreenshotUtil==null) {
			objScreenshotUtil = new ScreenshotUtil(driver);
		}
		return objScreenshotUtil;
	}

}
