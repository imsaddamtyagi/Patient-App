package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
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

public class VerifyPatientEmail extends TestBase {
	
	static long startTime;
	static long endTime;
	String email= "husainahamad055@gmail.com";

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.VerifyPatientEmail)
	@Test(enabled=true,description="Resend Verification Email From Patient Profile")
	public void ResendVerificationEmail() throws AWTException, InterruptedException
	{
	ExtentLogger.pass("Verifying Patient Email address in Patient Profile");
	driver.findElement(By.className("android.widget.ImageView")).click();
	ExtentLogger.pass("Clicked on side menu");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\"Mohd Husain\")"))).click();	
	ExtentLogger.pass("Clicked on Patient profile");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\""+email+"\")"))).click();	
	ExtentLogger.pass("Clicked on Patient Email Address");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\"Resend verification email\")"))).click();	
	ExtentLogger.pass("Clicked on Resend verification email");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\"OK\")"))).click();
	ExtentLogger.pass("Alert Accepted: Verification email has been sent");
        
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
