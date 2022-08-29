package common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of reusable methods which can be used only by Page
 * Library classes
 * 
 * @author krishna.d.hegde
 *
 */
public class Base {
	WebDriver driver;
	public static int explicitWaitInSeconds = 10;
	public static final Logger LOG = LogManager.getLogger(Base.class);


	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Explicit wait Conditions
	 */
	public enum Condition {
		VISIBLE, CLICKABLE;
	}

	public void waitFor(long waitTimeInMilliSeconds) throws InterruptedException {
		Thread.sleep(waitTimeInMilliSeconds);
	}

	public void waitFor(Condition condition, WebElement element) {
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitInSeconds));
		try {
			switch (condition) {
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			}
			found = true;
		} catch (Exception e) {
			if (found) {
				LOG.warn("Explicit wait failed");
			} else {
				LOG.error("Element not found");
			}
		}
	}

}
