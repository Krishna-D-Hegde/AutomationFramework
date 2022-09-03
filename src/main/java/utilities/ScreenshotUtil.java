package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * This class consists of methods to capture screenshots
 * 
 * @author krishna.d.hegde
 *
 */
public class ScreenshotUtil {
	WebDriver driver;

	public ScreenshotUtil(WebDriver driver) {
		this.driver = driver;
	}

	public synchronized String takeScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = StringConstants.USER_DIR + "\\reports\\screenshots\\" + name + StringConstants.SCREENSHOT_EXTENSION;
		FileHandler.copy(source, new File(destination));
		return destination;
	}

}
