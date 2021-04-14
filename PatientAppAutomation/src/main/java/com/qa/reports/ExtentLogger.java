package com.qa.reports;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		
		ExtentReportManager.getExtentTest().skip(message);
	}

	
	/*
	 * public static void pass(String message, boolean isScreenshotNeeded) {
	 * if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).
	 * equalsIgnoreCase("yes") && isScreenshotNeeded ) {
	 * ExtentManager.getExtentTest()
	 * .pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(
	 * ScreenshotUtils.getBase64Image()).build()); } else { pass(message); } }
	 */
	  
	 
	/*
	 * * Logs fail event in the extent report based on user input in property file
	 * 
	 * @author Amuthan Sakthivel Jan 21, 2021
	 * 
	 * @param message custom message that needs to be logged
	 * 
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	/*
	 * public static void fail(String message, boolean isScreenshotNeeded) {
	 * if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).
	 * equalsIgnoreCase("yes") && isScreenshotNeeded ) {
	 * ExtentManager.getExtentTest().fail(message,
	 * MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.
	 * getBase64Image()).build()); } else { fail(message); } }
	 * 
	 *//**
		 * Logs skip event in the extent report based on user input in property file
		 * 
		 * @author Amuthan Sakthivel Jan 21, 2021
		 * @param message            custom message that needs to be logged
		 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
		 *//*
			 * public static void skip(String message, boolean isScreenshotNeeded) {
			 * if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).
			 * equalsIgnoreCase("yes") && isScreenshotNeeded ) {
			 * ExtentManager.getExtentTest().skip(message,
			 * MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.
			 * getBase64Image()).build()); } else { skip(message); } }
			 */

}
