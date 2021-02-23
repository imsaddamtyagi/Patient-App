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
import base.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import util.TestUtil;

public class BookAnAppointment extends TestBase {
	
	static long startTime;
	static long endTime;
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
	startTime = System.nanoTime();		
	initialization();      
		} 
	
	
	@Test(priority=1,enabled=false)
	public void LoginInApp()
	{
		logger.info("Login Test Passed");
	}
	
		
	@Test(priority=2,enabled=false)
	public void BookInClinicAppointment() throws InterruptedException, AWTException, IOException
	{
		logger.info("Booking an In clinic appointment");
		  List<WebElement> buttons = driver.findElementsByClassName("android.widget.TextView");
		  for(WebElement button : buttons){
		  if(button.getText().trim().equals("Add Doctor")){
		  button.click(); 
		  logger.info("Add Doctor button clicked..."); 
		  Thread.sleep(3000);
		  }}
		  		 
		  logger.info("Searching Doctor");
       String Doc="Praveen Chauhan";
        MobileElement mobileElement=(MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));       
        mobileElement.click();
        Actions action = new Actions(driver);
        action.sendKeys(Doc).perform();
        
		    WebDriverWait wait3 = new WebDriverWait(driver,20);
		    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")));
		    ActualAcc.click();
		    logger.info("Doctor Selected");
			Thread.sleep(20000);
			  
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"07:10 PM\")"))).click();
			  logger.info("Time Slot Selected");
			  Thread.sleep(5000);
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	
			  logger.info("Patient Selected");
			  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();	 
			  Thread.sleep(5000);
			  logger.info("In clinic appointment successfull");
	}
	
	
	
	@Test(priority=3,enabled=true)
	public void BookVideoConsultation() throws InterruptedException, AWTException, IOException
	{
          logger.info("Booking video consultation");
		  List<WebElement> buttons = driver.findElementsByClassName("android.widget.TextView");
		  for(WebElement button : buttons){
		  if(button.getText().trim().equals("Add Doctor")){
		        button.click(); 
		        logger.info("Add Doctor button clicked...");
				  Thread.sleep(3000);
		        }}
		  		 
		  logger.info("Searching Doctor");       
    
            String Doc="Praveen ";
            MobileElement mobileElement=(MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));       
            mobileElement.click();
            mobileElement.clear();
            Actions actions = new Actions(driver);
            actions.sendKeys(Doc).perform();

    	    
		    WebDriverWait wait3 = new WebDriverWait(driver,20);
		    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")));
		    ActualAcc.click();
		    logger.info("Doctor Selected");
			Thread.sleep(20000);
			logger.info("Scrolling down until video consultation slots are visible");	
            TestUtil.ScrollingUntilEndOfPage();
			logger.info("Scrolling down finished");
			
	boolean a= driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).size()>0;
	if(a==true) 
	{  
		  logger.info("Video consultation is available");
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"04:35s PM\")"))).click();	
		  logger.info("Slot Selected");
		  Thread.sleep(5000);			
		  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	 
		  logger.info("Patient Selected");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();	
    	  logger.info("Submit button clicked");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Apply Offer\")"))).click();	 
    	  logger.info("Selecting offer");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Apply\")"))).click();	
    	  Thread.sleep(3000);
    	  logger.info("Offer applied");
    	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Confirm & Pay\")"))).click();	 
    	  Thread.sleep(5000);
    	  logger.info("Video consultation is booked successfully");
		
	 } else 
	 {	 		 
		 logger.info("No Video consultation available for this doctor");
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
	         logger.info("Failed TestName: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	     }
	     else if (testResult.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= testResult.getMethod().getMethodName();
	        	 logger.info("Passed TestName: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     logger.info("Total Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
         Thread.sleep(5000);
         logger.info("Ending Session");
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









