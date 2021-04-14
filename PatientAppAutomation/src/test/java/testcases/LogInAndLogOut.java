package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.reports.ExtentLogger;
import base.TestBase;
import io.appium.java_client.MobileBy;
import util.TestUtil;

public class LogInAndLogOut extends TestBase {
	
	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.LogInAndLogOut)	
	@Test(priority=1,enabled=true,description="Verify Login Test")
	public void LoginInApp()
	{
		ExtentLogger.pass("Login Test Passed");
	}
	
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.LogInAndLogOut)	
	@Test(priority=2,description="Verify Log out Test")
	public void LogOut() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
	    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Settings\")"))).click();
	    ExtentLogger.pass("Clicked on Setting menu");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.ImageView")).click();
	    ExtentLogger.pass("Clicked on sign-out");
	    Thread.sleep(5000);
	    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Logout\")"))).click();
	    ExtentLogger.pass("Sign-out success");
	}
	
	
	
	
	
	
	
	
	   @DataProvider
	    public Object[][] getDataFamily()          
	    {
	    	Object data[][]=TestUtil.getTestData(prop.getProperty("sheetNameForFamily"));
	    	return data;
	    }

	   @AfterMethod
	    public void TearDown(ITestResult testResult) throws IOException, InterruptedException
	    {
		   ExtentLogger.pass("Ending Session");
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
	     ExtentLogger.pass("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");       
         Thread.sleep(5000);
    	 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
		 ExtentLogger.pass("\n");
	 //    driver.quit();  
	    }
	    
	
	

}
