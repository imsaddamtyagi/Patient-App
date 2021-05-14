package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import io.appium.java_client.MobileElement;
import util.TestUtil;

public class BookAnAppointment extends TestBase {
	
	static long startTime;
	static long endTime;
	
    String DocForInClinic="Simanto";   
    String DocInitialsClinic="IDrts-987";
    String SlotForInClinic="06:55 PM";
    String Patient="Husain";
    
    String DocForVideo="Simanto";
    String DocInitialsVideo="IDrts-987";
    String SlotForVideo="05:00 PM";
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
	startTime = System.nanoTime();		
	initialization();      
		} 
	

	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.BookAnAppointment)	
	@Test(priority=1,enabled=true,description="Book In-clinic Appointment")
	public void BookInClinicAppointment() throws InterruptedException, AWTException, IOException
	{
		ExtentLogger.pass("Booking an In clinic appointment");
		  List<WebElement> buttons = driver.findElementsByClassName("android.widget.TextView");
		  for(WebElement button : buttons){
		  if(button.getText().trim().equals("Add Doctor")){
		  button.click(); 
		  ExtentLogger.pass("Add Doctor button clicked..."); 
		  Thread.sleep(5000);
		  }}
		  		 
	    ExtentLogger.pass("Searching Doctor");
        String Doc=DocForInClinic;
        MobileElement mobileElement=(MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));       
        mobileElement.click();
        mobileElement.clear();
        Actions action = new Actions(driver);
        action.sendKeys(Doc).perform();
        
        Thread.sleep(7000);
        
		    WebDriverWait wait3 = new WebDriverWait(driver,30);
		    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+DocInitialsClinic+"']")));
		    ActualAcc.click();
		    ExtentLogger.pass("Doctor Selected");
			Thread.sleep(10000);
			  
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+SlotForInClinic+"\")"))).click();
			  ExtentLogger.pass("Time Slot Selected");    
			  Thread.sleep(5000);
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+Patient+"\")"))).click();	
			  ExtentLogger.pass("Patient Selected");
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();	 
			  Thread.sleep(5000);
			  ExtentLogger.pass("In clinic appointment successfull");
		

	}
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.BookAnAppointment)	
	@Test(priority=2,enabled=true,description="Book video consultation")
	public void BookVideoConsultation() throws InterruptedException, AWTException, IOException
	{
          ExtentLogger.pass("Booking video consultation");
		  List<WebElement> buttons = driver.findElementsByClassName("android.widget.TextView");
		  for(WebElement button : buttons){
		  if(button.getText().trim().equals("Add Doctor")){
		        button.click(); 
		        ExtentLogger.pass("Add Doctor button clicked...");
				  Thread.sleep(3000);
		        }}
		  		 
		  ExtentLogger.pass("Searching Doctor");       
    
            String Doc=DocForVideo;
            MobileElement mobileElement=(MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));       
            mobileElement.click();
            mobileElement.clear();
            Thread.sleep(3000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Doc).perform();

            Thread.sleep(8000);
		    WebDriverWait wait3 = new WebDriverWait(driver,20);
		    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+DocInitialsVideo+"']")));
		    ActualAcc.click();
		    ExtentLogger.pass("Doctor Selected");
			Thread.sleep(20000);
			ExtentLogger.pass("Scrolling down until video consultation slots are visible");	
            TestUtil.ScrollingUntilEndOfPage();
			ExtentLogger.pass("Scrolling down finished");
			
	boolean a= driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).size()>0;
	if(a==true) 
	{  
		  ExtentLogger.pass("Video consultation is available");
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+SlotForVideo+"\")"))).click();	
		  ExtentLogger.pass("Slot Selected");     
		  Thread.sleep(5000);	
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+Patient+"\")"))).click();	
		  ExtentLogger.pass("Patient Selected");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();	
    	  ExtentLogger.pass("Submit button clicked");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Apply Offer\")"))).click();	 
    	  ExtentLogger.pass("Selecting offer");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Apply\")"))).click();	
    	  Thread.sleep(3000);
    	  ExtentLogger.pass("Offer applied");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Confirm & Pay\")"))).click();	 
    	  Thread.sleep(5000);
    	  ExtentLogger.pass("Confirm and pay is clicked");
		  ExtentLogger.pass("Video consultation booked successfull");

		
	 } else 
	 {	 		 
		 ExtentLogger.pass("No Video consultation available for this doctor");
		 Assert.fail("Marking this test failed");
		 }	
					
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
	     driver.quit();  
	    }
    
    
}



















/*
  List<WebElement> buttons1 = driver.findElementsByClassName("android.widget.EditText");
  for(WebElement button1 : buttons1){
  if(button1.getText().trim().equals("Search by doctor's name/ Id or Clinic name")){
  button1.click();	 
	  }}		  
  Thread.sleep(2000);

	  Robot robot = new Robot(); 
	  Thread.sleep(2000); 
	  robot.keyPress(KeyEvent.VK_P);
	  robot.keyPress(KeyEvent.VK_R); 
	  robot.keyPress(KeyEvent.VK_A);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyPress(KeyEvent.VK_E);
	  Thread.sleep(2000);
	  robot.keyPress(KeyEvent.VK_E);
	  robot.keyPress(KeyEvent.VK_N); 
	  Thread.sleep(2000);
	  robot.keyPress(KeyEvent.VK_SPACE); robot.keyPress(KeyEvent.VK_SPACE);
	 */


/*
List<WebElement> buttons1 = driver.findElementsByClassName("android.widget.EditText");
for(WebElement button1 : buttons1){
if(button1.getText().trim().equals("Search by doctor's name/ Id or Clinic name")){
	  button1.click();
}}

 Robot robot = new Robot();
	  Thread.sleep(2000);
 robot.keyPress(KeyEvent.VK_P);
 robot.keyPress(KeyEvent.VK_R);
 robot.keyPress(KeyEvent.VK_A);
 robot.keyPress(KeyEvent.VK_V);
 robot.keyPress(KeyEvent.VK_E);
 Thread.sleep(2000);
 robot.keyPress(KeyEvent.VK_E);
 robot.keyPress(KeyEvent.VK_N);
 Thread.sleep(2000);
 robot.keyPress(KeyEvent.VK_SPACE); 
 robot.keyPress(KeyEvent.VK_SPACE); 

 */









