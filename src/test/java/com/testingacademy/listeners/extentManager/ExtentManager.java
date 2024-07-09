package com.testingacademy.listeners.extentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
            htmlReporter.config().setDocumentTitle("ATB6x Automation Report");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setReportName("Automation ATB6X Test Report");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name/OS", "ATB6x/Mac");
            extent.setSystemInfo("Tester Name", "Samarth");
            extent.setSystemInfo("Browser", "Chrome");

        }
        return extent;
    }
    public static ExtentTest createTest(String name, String description){
        test = getInstance().createTest(name, description);
        return test;
    }
}
