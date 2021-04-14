package testcases;


import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.reports.ExtentLogger;
import base.TestBase;
import io.appium.java_client.MobileBy;
import util.TestUtil;

public class JoinVideoConsultation extends TestBase {
	
	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.JoinVideoConsultation)
	@Test(enabled=true,description="Join Video Call")
	public void JoinVideoConsultationTest() throws InterruptedException
	{
		
		ExtentLogger.pass("Verify Join Now in Video Appointment");	
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
		ExtentLogger.pass("Clicked on Appointment section");	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().text(\"Video Consultation\"))").click();
		ExtentLogger.pass("Video consultation selected");	
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Join Now\")"))).click();
		ExtentLogger.pass("Join Now Button is clicked");		
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"While using the app\")"))).click();
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"While using the app\")"))).click();
		ExtentLogger.pass("Alerts Accepted");	
	//	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Start call\")"))).click();
		ExtentLogger.pass("Clicked on start call");	
		Thread.sleep(5000);
//		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"End call\")"))).click();
		ExtentLogger.pass("Clicked on End call");	
		
	
		
	}
	
	   @AfterMethod
	    public void TearDown(ITestResult testResult) throws IOException, InterruptedException
	    {
	     Thread.sleep(2000);
	     if (testResult.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= testResult.getMethod().getMethodName();
	         ExtentLogger.pass("Failed TestName: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	         ExtentLogger.fail("Test Failed: "+FailedTestName);
	     }
	     else if (testResult.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= testResult.getMethod().getMethodName();
	        	 ExtentLogger.pass("Passed TestName: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     ExtentLogger.pass("Total Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
        Thread.sleep(5000);
        ExtentLogger.pass("Ending Session");
   	 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
	 //    driver.quit();  
	    }
   

	
	

}
