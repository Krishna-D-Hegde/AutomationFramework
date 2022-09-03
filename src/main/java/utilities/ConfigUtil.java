package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import commonMain.POMBase;

/**
 * This class is used to define Run Time Configurations
 * 
 * @author krishna.d.hegde
 *
 */
public class ConfigUtil {
	public enum Browser {
		CHROME, FIREFOX, OPERA, INTERNET_EXPLORER, EDGE, SAFARI;
	}

	public enum RunEnvironment {
		TEST;
	}

	public static Browser browserName = Browser.CHROME;
	public static RunEnvironment runEnv = RunEnvironment.TEST;
	public static int retryCount = 0;

	/*----------------------------------------------------*/

	public static final Logger LOG = LogManager.getLogger(ConfigUtil.class.getName());

	/**
	 * Loads properties file base on Run Environment
	 * @return
	 */
	public Properties setProperties() {
		String fileName = "";
		FileInputStream fis = null;
		switch (runEnv) {
		case TEST:
			fileName = StringConstants.CONFIG_TEST;
			break;
		default:
			fileName = StringConstants.CONFIG_TEST;
		}
		String path = StringConstants.USER_DIR + "\\resources\\properties\\" + fileName + ".properties";
		try {
			fis = new FileInputStream(path);
		} catch (Exception e) {
			LOG.error(e + ": Could not Read File");
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
			LOG.info(fileName + " successfully loaded.");
		} catch (Exception e) {
			LOG.error(e + ": Could not Load File");

		}
		return prop;
	}

}
