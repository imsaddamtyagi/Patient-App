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
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import util.TestUtil;

public class NetworkStatus extends TestBase {
	
	static long startTime;
	static long endTime;
	
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initToLaunch();             
		} 
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.NetworkStatus)
	@Test(priority=1,enabled=true,description="CheckNetworkStatus")
	public void NetworkStatusTest() throws InterruptedException 
	{
		
		ExtentLogger.pass("Checking internet availablity in the application by Turning off mobile internet");
		
		try {
			driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
			ExtentLogger.pass("Switching OFF the connection : " + driver.getConnection());
		} catch (Exception e) {
			ExtentLogger.pass("Connection could not be switch OFF");
		}
		
		Thread.sleep(5000);
		
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); alert.accept();
		  ExtentLogger.pass("Network Alert Accepted: Alerts are coming in case of network ");
		
		
		
		  try {
		        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		        ExtentLogger.pass("Switching On the connection: " + driver.getConnection());
		    } catch (Exception e) {
		    	ExtentLogger.pass("Connection could not be switch ON");
		    }

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
	     driver.quit();  
	    }
	
	
	
	
	
	

}
