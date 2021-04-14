package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class HelpAndSupport extends TestBase  {
	

	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
		
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.HelpAndSupport)
	@Test(priority=1,description="Searching Questions in Help And Support")
	public void HelpAndSupportSearching() throws InterruptedException
	{
		ExtentLogger.pass("Verify Searching in Help and Support");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Help & Support\")"))).click();	
		ExtentLogger.pass("Clicked on Help and Support menu");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on Search icon");
		Thread.sleep(3000);
		driver.findElement(By.xpath( "//android.widget.EditText[@text='Search']")).click();
		ExtentLogger.pass("Searching 'patient' in search icon");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
	    action.sendKeys("patient").perform();
	    Thread.sleep(10000);
	    
	    List<WebElement> Questions=   driver.findElements(By.className("android.widget.TextView"));
	    for(WebElement Question : Questions){
	    	Question.click();
	    	Question.click();
	    	break;
	    }

	    
		  ExtentLogger.pass("Clicked on Suggested Question");
		  
		String FAQ=  driver.findElement(By.xpath( "//android.widget.TextView[@text='FAQ']")).getText();
		ExtentLogger.pass(FAQ+" Page is present");
		ExtentLogger.pass("Scrolling down now");
		TestUtil.ScrollingUntilEndOfPage();

		ExtentLogger.pass("Selecting YES on Was This Answer Helpful");
		  List<WebElement> buttons1 = driver.findElements(By.className("android.widget.TextView"));
		  for(WebElement button1 : buttons1){
		  if(button1.getText().equals("Yes")){
			  button1.click();
	  }}
		
		  ExtentLogger.pass("Radio Button Yes is selcted ");
		
     }

	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.HelpAndSupport)
	@Test(priority=2,description="Searching in Help And Support Call on Mobile")
	public void HelpAndSupportCall() throws InterruptedException
	{
		ExtentLogger.pass("Verify Call Feature in Help and Support");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Help & Support\")"))).click();	
		ExtentLogger.pass("Clicked on Help and Support menu");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on Headphone Icon");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Call\")"))).click();	
		ExtentLogger.pass("Dial Pad is opened to place a call");			
	}

	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.HelpAndSupport)
	@Test(priority=3,description="Searching in Help And Support Email Support")
	public void HelpAndSupportEmail() throws InterruptedException
	{
		ExtentLogger.pass("Verify Email Feature in Help and Support");
		driver.findElement(By.className("android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on side menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Help & Support\")"))).click();	
		ExtentLogger.pass("Clicked on Help and Support menu");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView")).click();
		ExtentLogger.pass("Clicked on Headphone Icon");
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Email\")"))).click();	
		ExtentLogger.pass("Gmail is opened to place a call");			
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