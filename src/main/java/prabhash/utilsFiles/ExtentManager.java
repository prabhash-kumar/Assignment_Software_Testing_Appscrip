package prabhash.utilsFiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
    	sparkReporter.config().setTheme(Theme.STANDARD);
    	sparkReporter.config().setDocumentTitle("Appscrip Assignmet");
    	sparkReporter.config().setReportName("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Prabhash Kumar");

        return extent;
    }
}
