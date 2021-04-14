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
import io.appium.java_client.MobileBy;
import util.TestUtil;

public class AboutDrona extends TestBase {
	
	static long startTime;
	static long endTime;
	
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.AboutDrona)
	@Test(priority=1,enabled=true,description="Verify About us")
	public void VerifyAboutUs() throws InterruptedException
	{
		
		ExtentLogger.pass("Verifying that About is present in About Drona Section");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"About Drona\")"))).click();	
		ExtentLogger.pass("Clicked on About Dona menu");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@index=0 and contains(@text,'About Us:')]")).click();
		ExtentLogger.pass("About us is present in the Section");
}
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.AboutDrona)
	@Test(priority=2,enabled=true,description="Verify Terms of use")
	public void VerifyTermsOfUse() throws InterruptedException
	{
		
		ExtentLogger.pass("Verifying that Terms of use is present in About Drona Section");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"About Drona\")"))).click();	
		ExtentLogger.pass("Clicked on About Dona menu");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Terms of Use\")"))).click();	
		ExtentLogger.pass("Clicked on Terms of use");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Terms of Use\")"))).click();	
		ExtentLogger.pass("Terms of use page is present in the Section");
		TestUtil.ScrollingUntilEndOfPage();
		ExtentLogger.pass("Scroll down until End of the page is working");
}
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.AboutDrona)
	@Test(priority=3,enabled=true,description="Verify Privacy Policy")
	public void VerifyPrivacyPolicy() throws InterruptedException
	{
		
		ExtentLogger.pass("Verifying that Privacy Policy is present in About Drona Section");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"About Drona\")"))).click();	
		ExtentLogger.pass("Clicked on About Dona menu");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Privacy Policy\")"))).click();	
		ExtentLogger.pass("Clicked on Terms of use");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Privacy Policy\")"))).click();	
		ExtentLogger.pass("Privacy Policy page is present in the Section");
		TestUtil.ScrollingUntilEndOfPage();
		ExtentLogger.pass("Scroll down until End of the page is working");
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