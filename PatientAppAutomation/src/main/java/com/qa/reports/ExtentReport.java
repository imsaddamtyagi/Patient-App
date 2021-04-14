package com.qa.reports;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.enums.CategoryType;

public final class ExtentReport {
	
	
	private ExtentReport() {}
	
	private static String windowsPath = System.getProperty("user.dir")+ "/TestReport";
	private static String reportFileName = "PatientAppAutomationReport.html";
	private static ExtentReports extent;

	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(windowsPath + "/" + reportFileName); 
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Patient App Automation Report.");
			spark.config().setReportName("Patient App Automation Report.");
		}
	}

	public static void flushReports(){
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentReportManager.unload();
		try {
			Desktop.getDesktop().browse(new File(windowsPath + "/" + reportFileName).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTest(String testcasename) {
		ExtentReportManager.setExtentTest(extent.createTest(testcasename));
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentReportManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentReportManager.getExtentTest().assignCategory(temp.toString());
		}
	}

}
