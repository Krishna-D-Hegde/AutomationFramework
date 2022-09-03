package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * This class generates an empty Extent Report with Thread Safety
 * 
 * @author krishna.d.hegde
 *
 */
public class ReportUtil {
	public static String reportPath = StringConstants.USER_DIR + "\\reports\\TestReport.html";
	public static ExtentSparkReporter reporter;

	public static void configureExtentReport() {
		reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName(StringConstants.REPORT_NAME);
		reporter.config().setDocumentTitle(StringConstants.REPORT_TITLE);
	}

	public static ExtentReports generateExtentReport() {
		configureExtentReport();
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
