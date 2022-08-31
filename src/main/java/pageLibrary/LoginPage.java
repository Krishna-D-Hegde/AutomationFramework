package pageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commonMain.Base;

/**
 * This class consists of WebElements and Methods related to Login Page
 * @author krishna.d.hegde
 *
 */
public class LoginPage extends Base{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String url) {
		System.out.println(url);

	}
	
}
