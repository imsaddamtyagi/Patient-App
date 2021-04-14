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

public class Registration extends TestBase {
	
	

	static long startTime;
	static long endTime;
	
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	

	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.Registration)
	@Test(priority=2,description="Register new Patient")
	public void RegisterationTest() throws InterruptedException
	{
		Thread.sleep(5000);
		ExtentLogger.pass("Registering new patient");	
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")).click();		
		Thread.sleep(3000); 
		 Actions action = new Actions(driver);
	     action.sendKeys("Mohd Monu").perform();
		ExtentLogger.pass("First name entered");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")).click();
		 Thread.sleep(3000);  
		 Actions action0 = new Actions(driver);
	     action0.sendKeys("Tyagi").perform();
		ExtentLogger.pass("Last name entered");
		Thread.sleep(3000);  
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView")).click();
		Thread.sleep(3000);  
		Actions action1 = new Actions(driver);
	    action1.sendKeys("04/04/2000").perform();
		ExtentLogger.pass("DOB entered");
		 Thread.sleep(3000);  

	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Male\")"))).click();
	       Thread.sleep(3000);  
	       ExtentLogger.pass("gender Selected");
	       driver.navigate().back();
	       
	    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Email Address\")"))).click();
	   	Thread.sleep(3000);  
		Actions action2 = new Actions(driver);
	     action2.sendKeys("husainahamad055@gmail.com").perform();
		ExtentLogger.pass("Email entered");
		 Thread.sleep(3000);  
		 driver.navigate().back();
	       
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();
	       Thread.sleep(3000);  
	       ExtentLogger.pass("Submit Button Clicked");
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\"Pick my current location\")"))).click();
	       ExtentLogger.pass("Current Location Selected");
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
