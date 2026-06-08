package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			ExtentSparkReporter spark 
			= new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("BStackDemo Automation Report");
			spark.config().setReportName("E-Commerce Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Application", "bstackdemo.com");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		return extent;
	}

}
