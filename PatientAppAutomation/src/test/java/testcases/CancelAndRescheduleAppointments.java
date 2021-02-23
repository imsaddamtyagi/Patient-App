package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import io.appium.java_client.MobileBy;
import util.TestUtil;

public class CancelAndRescheduleAppointments extends TestBase {
	
	static long startTime;
	static long endTime;
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
	startTime = System.nanoTime();		
	initialization();      
	} 
	
	
	
	@Test(priority=1,enabled=true)
	public void CancelInClinicAppointment() throws InterruptedException
	{		
	logger.info("Cancel in-clinic appointment");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	logger.info("Clicked on Appointment section");	
	Thread.sleep(10000);
	boolean a=	driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Hospital')]")).size()>0;
	if(a==true) 
	{
	logger.info("In-clinic appointments are available");
	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Hospital')][1]")).click();
	logger.info("In-clinic Appointment selected");
	Thread.sleep(10000);
	logger.info("Scrolling down now...");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Patient Details\")"))).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
	+"(new UiSelector().textContains(\"Cancel Appointment\"))").click();
	
    logger.info("Scrolling down finished and clicked on cancel appointment");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Booked wrong clinic\")"))).click();
    logger.info("Reason:Booked wrong clinic selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Yes\")"))).click();	
	logger.info("In-clinincAppointment Cancelled");
	}
	else
	{
		logger.info("No In-clinic appointment is available to cancel");
		Assert.fail("Marking this test failed");
	}
	
	}
	
	

	@Test(priority=2,enabled=true)
	public void RescheduleInClinicAppointment() throws InterruptedException
	{
	logger.info("Reschedule an In-clinic appointment");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	logger.info("Clicked on Appointment section");
	boolean a=	driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Hospital')]")).size()>0;
	if(a==true) 
	{
	logger.info("In-clinic appointments are available");		
	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Hospital')]")).click();
	logger.info("In-clinic appointment selected");
	logger.info("Scrolling now..");
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
			+"(new UiSelector().textContains(\"Reschedule Appointment\"))").click();
	logger.info("Scrolling finished");
//	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Reschedule Appointment\")"))).click();
	logger.info("Clicked on Reschedule Appointment");
	Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"View All Slots\")"))).click();
	Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"07:25 PM\")"))).click();
	logger.info("Slot selected");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	
    logger.info("Patient selected from the list");
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Submit\"))").click();	        
	}
	else
	{
		logger.info("No In-clinic appointment is available to Reschedule");
		Assert.fail("Marking this test failed");
	}
	}
	
	
	
	@Test(priority=3,enabled=true)
	public void CancelVideoConsultationAppointment() throws InterruptedException
	{		
	logger.info("Cancel an video consultation appointment");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	logger.info("Clicked on Appointment section");	
	boolean a= driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).size()>0;
	if(a==true) 
	{
	logger.info("Video consultation is selected from Upcoming appointments section");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).click();
	logger.info("Video Appointment selected");
	Thread.sleep(15000);
	logger.info("Scrolling down...");
	TestUtil.ScrollingUntilEndOfPage();
    logger.info("Scrolling down finished");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Cancel Appointment\")"))).click();	
	logger.info("Clicked on Cancel Appointment Button");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Booked wrong clinic\")"))).click();
    logger.info("Reason:Booked wrong clinic selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Yes\")"))).click();	
	logger.info("Appointment Cancelled");
	}
	else
	{
		logger.info("No Video consultation is available to cancel");
		Assert.fail("Marking this test failed");
	}
	
	}
	
	
	
	@Test(priority=4,enabled=true)
	public void RescheduleVideoAppointment() throws InterruptedException
	{
	logger.info("Reschedule an appointment");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	logger.info("Clicked on Appointment section");
	boolean a= driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).size()>0;
	if(a==true) 
	{
	logger.info("Video consultation is selected from Upcoming appointments section");		
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).click();
	logger.info("Video Appointment selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Reschedule Appointment\")"))).click();
	logger.info("Clicked on Reschedule Appointment");
	Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"View All Slots\")"))).click();
	Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"07:25 PM\")"))).click();
	logger.info("Slot selected");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	
    logger.info("Patient selected from the list");
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Submit\"))").click();	        
	}
	else
	{
		logger.info("No Video consultation is available to Reschedule");
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
	    public void TearDown(ITestResult tr) throws IOException, InterruptedException
	    {
	     Thread.sleep(2000);
	     if (tr.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= tr.getMethod().getMethodName();
	    	 logger.info("Failed Test: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	     }
	     else if (tr.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= tr.getMethod().getMethodName();
	        	 logger.info("Passed Test: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     logger.info("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
         Thread.sleep(5000);
         logger.info("Ending Session after test");
	     driver.quit();  
	    }

}
