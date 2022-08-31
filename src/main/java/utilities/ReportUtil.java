package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtil{
	//WebDriver driver;
	public static String reportPath = StringConstants.USER_DIR + "\\reports\\TestReport.html";
	public static ExtentSparkReporter reporter;
	
	public static void configureExtentReport() {
		reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName(StringConstants.REPORT_NAME);
		reporter.config().setDocumentTitle(StringConstants.REPORT_TITLE);
	}
	
	public synchronized static ExtentReports generateExtentReport() {
		configureExtentReport();
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Report created");
		return extent;
	}
	
	

}
