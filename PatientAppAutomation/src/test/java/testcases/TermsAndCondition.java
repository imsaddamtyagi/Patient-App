package testcases;

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
import util.TestUtil;

public class TermsAndCondition extends TestBase {

	static long startTime;
	static long endTime;
	
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initToLaunch();             
		} 
	
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.TermsAndCondition)
	@Test(priority=1,description="Verify Terms&Conditions Link")
	public void VerifyTermsAndConditionLink()
	{
		ExtentLogger.pass("Verifying that Terms&Conditions Link is working");
		driver.findElement(By.xpath("//android.widget.TextView[@index=6 and contains(@text,'Terms & Conditions')]")).click();
		ExtentLogger.pass("Clicked on Terms&Condition Link");
     }
	
	
	   @AfterMethod
	    public void TearDown(ITestResult testResult) throws IOException, InterruptedException
	    {
	     Thread.sleep(2000);
	     if (testResult.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= testResult.getMethod().getMethodName();
	    	 ExtentLogger.pass("Failed test: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	         ExtentLogger.fail("Test Failed: "+FailedTestName);
	     }
	     else if (testResult.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= testResult.getMethod().getMethodName();
	        	 ExtentLogger.pass("Passed Test name: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     ExtentLogger.pass("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
		 ExtentLogger.pass("Ending Session after Tests");
		 Thread.sleep(5000);
		 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");   
	     driver.quit();  
	    }
	    	  
	
	
	
	
	
	
     }