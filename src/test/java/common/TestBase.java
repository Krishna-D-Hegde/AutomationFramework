package common;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigUtil;

/**
 * This class consists of reusable methods which can be used on by Test classes
 * 
 * @author krishna.d.hegde
 *
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	public static final Logger LOG = LogManager.getLogger(TestBase.class);

	public void createDriver() {
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
		} catch (Exception e) {
			LOG.error(e+": could not create driver");
		}
		properties = ConfigUtil.setProperties();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		createDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		// driver.close();
	}
}
