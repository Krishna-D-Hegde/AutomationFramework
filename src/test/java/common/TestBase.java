package common;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonMain.PageObjectRepository;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.*;

public class TestBase implements ITestListener {
	protected WebDriver driver;
	protected Properties properties;
	protected PageObjectRepository POR;
	protected String methodName;
	private static ExtentReports extent;
	private static ExtentTest test;
	private static String screenshotPath;
	private static final Logger LOG = LogManager.getLogger(TestBase.class);

	@Override // Execution Order - 1
	public void onStart(ITestContext context) {
		extent = ReportUtil.generateExtentReport();
	}

	@BeforeMethod // Execution Order - 2
	public void beforeMethod() {
		createDriver();
		objPOR();
	}

	@Override // Execution Order - 3
	public void onTestStart(ITestResult result) {
		methodName = result.getName();
		test = extent.createTest(methodName);
	}

	@Override // Execution Order - 4
	public void onTestSuccess(ITestResult result) {
		test.pass("Passed");
	}

	@Override // Execution Order - 4
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	}

	@Override // Execution Order - 4
	public void onTestSkipped(ITestResult result) {

	}

	@AfterMethod // Execution Order - 5
	public void afterMethod() {
		try {
			screenshotPath = POR.objScreenshotUtil().takeScreenshot(methodName);
			test.addScreenCaptureFromPath(screenshotPath, methodName);
		} catch (IOException e) {
			System.out.println(e);
		}
		driver.close();
	}

	@Override // Execution Order - 6
	public void onFinish(ITestContext context) {
		System.out.println("From finish");
		extent.flush();
	}

	/*-------------------------------------------------------------------------------------------*/

	public WebDriver createDriver() {
		ConfigUtil config = new ConfigUtil();
		properties = config.setProperties();
		try {
			switch (ConfigUtil.browserName) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case SAFARI:
				WebDriverManager.safaridriver().setup();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(properties.getProperty(StringConstants.URL));
		} catch (Exception e) {
			LOG.error(e + ": could not create driver");
		}
		return driver;
	}

	public void objPOR() {
		POR = new PageObjectRepository(driver);
		System.out.println(POR);
	}

}
