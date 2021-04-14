package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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

public class Location extends TestBase {
	
	
	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.Location)
	@Test(priority=1,description="Set Current Location at Home Page")
	public void SetCurrentLocation() throws InterruptedException
	{
	
		ExtentLogger.pass("Setting Home Page Location to Current Location");
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on Location Menu at Home Page ");
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Pick my current location\")"))).click();	
		ExtentLogger.pass("Clicked on Pick my current location");
	}
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.Location)
	@Test(priority=2,description="Set Location manually")
	public void SetManualLocation() throws InterruptedException
	{
	
		ExtentLogger.pass("Manually setting home page location");
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on Location Menu at Home Page ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Select your city')]")).click();	
		Thread.sleep(4000);
		ExtentLogger.pass("Clicked on select your location");
		 Actions action = new Actions(driver);
	     action.sendKeys("Noida").perform();
	     ExtentLogger.pass("Location name entered");
	     Thread.sleep(5000);
	     driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Noida, Uttar Pradesh, India\")"))).click();	
		 ExtentLogger.pass("Selected location name from suggestion");
		 Thread.sleep(4000);
	     driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Confirm\")"))).click();	
	     ExtentLogger.pass("Confirm Button clicked");
		
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
