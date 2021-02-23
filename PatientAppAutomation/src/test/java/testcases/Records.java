package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import io.appium.java_client.MobileBy;
import util.TestUtil;

public class Records extends TestBase {
	
	static long startTime;
	static long endTime;
		
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();     
		} 
	
	
	@Test(priority=1,dataProvider="getDataForPrescription")
	public void AddPrescription(String Title, String Date) throws InterruptedException, AWTException
	{
		logger.info("Adding Prescription: '"+Title+"' with date: "+Date);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Records\")"))).click();
		logger.info("Clicked on Records menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Prescriptions\")"))).click();
		logger.info("Clicked on prescriptions");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"+ Add\")"))).click();
		logger.info("Clicked on Add Button");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Upload from gallery\")"))).click();
		logger.info("Clicked on Upload from gallery");

		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); 
		  alert.accept();
		  logger.info("Alert Accepted");
		  	  
			driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"images\")"))).click();
			logger.info("Clicked on Images folder in mobile gallery");			
			// get all images and then select index
			List<WebElement> pic= driver.findElements(By.className("android.view.ViewGroup"));
			pic.get(1).click(); // click based on index of image

			
			Thread.sleep(15000);
            logger.info("Image selecetd");
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.EditText")).sendKeys(Title);
            logger.info("Priscription title entered: "+Title);

			// Getting Today from date.
			  String str= Date.replaceAll("[^\\d]","").trim(); // Replace values that are not Digits.
              String zero="0";
              if(str.substring(0,1).equals(zero)) // If first digit of date is 0.
              {
      	    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.widget.ImageView\r\n"+"")).click();
                logger.info("Clicked on date picker to add date in prescription");
      	    	Thread.sleep(3000);   
  			    String SecondDigit =str.substring(1,2);  // Second digit from todays's date
    	  	    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+SecondDigit+"\")"))).click();     	  
                logger.info("Date entered: "+SecondDigit);

              }
              else
              {
        	    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.widget.ImageView\r\n"+"")).click();
                    logger.info("Clicked on date picker to add date in prescription");
        	    	Thread.sleep(3000);   
      			    String TwoDigit =str.substring(0,2);  // First digit and second digit from todays's date
        	  	    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+TwoDigit+"\")"))).click();     	            	  
                    logger.info("Date entered: "+TwoDigit);
              }
            	  
   	       Thread.sleep(3000);
			driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();
			logger.info("Submit button clicked");
			logger.info("Prescription Added: '"+Title+"' with date: "+Date);
	}
	
	
	
	
	@Test(priority=2,dataProvider="getDataForLabReports")
	public void AddLabReports(String Title, String Date) throws InterruptedException, AWTException
	{
		logger.info("Adding Lab Report: '"+Title+"' with date: "+Date);
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Records\")"))).click();
		logger.info("Clicked on Records menu");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Lab Reports\")"))).click();
		logger.info("Clicked on Lab Repotrs");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"+ Add\")"))).click();
		logger.info("Clicked on Add button");
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Upload from gallery\")"))).click();
		logger.info("Clicked on Upload image from gallery");

		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); 
		  alert.accept();
		  logger.info("Alert Accepted");
		  
			driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"images\")"))).click();
			logger.info("Images folder clicked in phone gallery");
			// get all images and then select index
			List<WebElement> pic= driver.findElements(By.className("android.view.ViewGroup"));
			pic.get(1).click(); // click based on index of image
			Thread.sleep(15000);
			logger.info("Image Selected from mobile gallery");
	
		   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.EditText")).sendKeys(Title);
		   logger.info("Lab Report title entered: "+Title);
		   
			// Getting Today from date.
		   String str= Date.replaceAll("[^\\d]","").trim(); // Replace values that are not Digits.
           String zero="0";
           if(str.substring(0,1).equals(zero)) // If first digit of date is 0.
           {  
		   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.widget.ImageView\r\n"+ "")).click();
		   logger.info("Clicked on Date Picker to add date in Lab Report");
		   Thread.sleep(3000); 
           String SecondDigit =str.substring(1,2);  // Second digit from todays's date
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+SecondDigit+"\")"))).click();
	       logger.info("Date entered: "+SecondDigit);
           }
           else
           {
    		   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]/android.widget.ImageView\r\n"+ "")).click();
    		   logger.info("Clicked on Date Picker to add date in Lab Report");
    		   Thread.sleep(3000); 
 			   String TwoDigit =str.substring(0,2);  // First digit and second digit from todays's date
    	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+TwoDigit+"\")"))).click();      	   
    	       logger.info("Date entered: "+TwoDigit);
           }
	       Thread.sleep(4000);
	//	   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys(Date);
		   driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Submit\")"))).click();
		   logger.info("Submit button clicked");
		   logger.info("Lab Report added: '"+Title+"' with date: "+Date);  

	}
	
	
	
	   @DataProvider
	    public Object[][] getDataForPrescription()          
	    {
	    	Object data[][]=TestUtil.getTestData(prop.getProperty("sheetNameForPrescription"));
	    	return data;
	    }

	   @DataProvider
	    public Object[][] getDataForLabReports()          
	    {
	    	Object data[][]=TestUtil.getTestData(prop.getProperty("sheetNameForLabReports"));
	    	return data;
	    }

	   
	   @AfterMethod
	    public void TearDown(ITestResult testResult) throws IOException, InterruptedException
	    {
	     Thread.sleep(2000);
	     if (testResult.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= testResult.getMethod().getMethodName();
	    	 logger.info("Failed test: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	     }
	     else if (testResult.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= testResult.getMethod().getMethodName();
	        	 logger.info("Passed Test name: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     logger.info("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
		 logger.info("Ending Session after Test");
         Thread.sleep(5000);
	     driver.quit();  
	    }
	    	   
}


















/*		   
//	  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Take a photo\")"))).click();
	  WebDriverWait waits = new WebDriverWait(driver,20);
	  waits.until(ExpectedConditions.alertIsPresent()); 
	  Alert alerts =  driver.switchTo().alert(); 
	  alerts.accept();
	  System.out.println("Alert Accepted");
	  Thread.sleep(3000);	  
	  driver.findElement(By.xpath("//*[@resource-id='com.android.camera2:id/shutter_button']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@resource-id='com.android.camera2:id/done_button']")).click();
	  */

/*
driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Title \")"))).click();

  Robot robot = new Robot(); 
  Thread.sleep(2000); 
  robot.keyPress(KeyEvent.VK_C);
  robot.keyPress(KeyEvent.VK_O); 
  robot.keyPress(KeyEvent.VK_R);
  robot.keyPress(KeyEvent.VK_O);
  robot.keyPress(KeyEvent.VK_N);
  robot.keyPress(KeyEvent.VK_A);
  Thread.sleep(2000); 
  System.out.println("Prescription name entered");
  driver.navigate().back();
  */
/*
  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Title \")"))).click();		
  Robot robot = new Robot(); 
  Thread.sleep(2000); 
  robot.keyPress(KeyEvent.VK_C);
  robot.keyPress(KeyEvent.VK_O); 
  robot.keyPress(KeyEvent.VK_R);
  robot.keyPress(KeyEvent.VK_O);
  robot.keyPress(KeyEvent.VK_N);
  robot.keyPress(KeyEvent.VK_A);
  Thread.sleep(2000); 
System.out.println("Lab name entered");
driver.navigate().back();      
*/
