package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Onboarding extends TestBase {
	
	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		Launch();             
		} 
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.Onboarding)
	@Test(priority=1,enabled=true,description="Verifying Skip Functionality")
	public void VerifySkipButton()
	{
		
		  ExtentLogger.pass("Launching Application");		
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Skip\")"))).click();
		  ExtentLogger.pass("Clicked on Skip button to proceed for login");
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); alert.accept();
		  ExtentLogger.pass("Alert Accepted");
		  ExtentLogger.pass("Login page is coming after skip button");
		  
	}
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.Onboarding)
	@Test(priority=2,enabled=true,description="Verifying Next Button Functionality")
	public void VerifyNextButton() throws InterruptedException
	{
		
		  ExtentLogger.pass("Launching Application");		
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Next\")"))).click();
		  Thread.sleep(2000);
		  ExtentLogger.pass("Clicked on Next Button");
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Next\")"))).click();
		  Thread.sleep(2000);
		  ExtentLogger.pass("Clicked on Next Button");
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Next\")"))).click();
		  Thread.sleep(2000);
		  ExtentLogger.pass("Clicked on Next Button");
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Get Started\")"))).click();
		  Thread.sleep(2000);
		  ExtentLogger.pass("Clicked on Get Started to proceed for login");
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); alert.accept();
		  ExtentLogger.pass("Alert Accepted");
		  ExtentLogger.pass("Login page is coming after Next button");  
	}
	
	
	
	
	
	  @AfterMethod
	    public void TearDown(ITestResult tr) throws IOException, InterruptedException
	    {
	     Thread.sleep(2000);
	     if (tr.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= tr.getMethod().getMethodName();
	    	 ExtentLogger.pass("Failed Test: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	         ExtentLogger.fail("Test Failed: "+FailedTestName);
	     }
	     else if (tr.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= tr.getMethod().getMethodName();
	        	 ExtentLogger.pass("Passed Test: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     ExtentLogger.pass("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
       Thread.sleep(5000);
       ExtentLogger.pass("Ending Session after test");
  	 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
		 Thread.sleep(5000);
	     driver.quit();  
	    }

	
	

}
