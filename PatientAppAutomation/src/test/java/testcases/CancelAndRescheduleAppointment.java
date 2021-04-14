package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import util.TestUtil;

public class CancelAndRescheduleAppointment extends TestBase {
	
	static long startTime;
	static long endTime;
	                                
	String DocClinic="Dr Praveen Chauhan";
	String SlotInClinic="10:30 AM";
	String SlotVideo="10:40 AM";
	
	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
	startTime = System.nanoTime();		
	initialization();      
	} 
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.CancelAndRescheduleAppointment)	
	@Test(priority=1,enabled=false,description="Cancel in clinic Appointment")
	public void CancelInClinicAppointment() throws InterruptedException
	{		
		Thread.sleep(5000);
	ExtentLogger.pass("Going to Cancel in-clinic appointment");	   
	driver.findElement(By.xpath("//android.widget.TextView[@index=1 and contains(@text,'Appointments')]")).click();
	ExtentLogger.pass("Clicked on Appointment section");	
	Thread.sleep(10000);
	boolean a=	driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'"+DocClinic+"')]")).size()>0;
	if(a==true) 
	{
	ExtentLogger.pass("In-clinic appointments are available");
	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+DocClinic+"')]")).click();
	ExtentLogger.pass("In-clinic Appointment selected");
	Thread.sleep(10000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Doctor\")"))).click();
	Thread.sleep(5000);
	TestUtil.ScrollingUntilEndOfPage();
	Thread.sleep(5000);
	ExtentLogger.pass("Scrolling down now...");
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
	+"(new UiSelector().text(\"Cancel Appointment\"))").click();
    ExtentLogger.pass("Scrolling down finished and clicked on cancel appointment");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Booked wrong clinic\")"))).click();
    ExtentLogger.pass("Reason:Booked wrong clinic selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Yes\")"))).click();	
	ExtentLogger.pass("In-clinincAppointment has been Cancelled");
	}
	else
	{
		ExtentLogger.pass("No In-clinic appointment is available to cancel");
		Assert.fail("Marking this test failed");
	}
	
	}
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.CancelAndRescheduleAppointment)	
	@Test(priority=2,enabled=false,description="Reschedule in clinic Appointment")
	public void RescheduleInClinicAppointment() throws InterruptedException
	{
	ExtentLogger.pass("Reschedule an In-clinic appointment");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	ExtentLogger.pass("Clicked on Appointment section");
	boolean a=	driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'"+DocClinic+"')]")).size()>0;
	if(a==true) 
	{
	ExtentLogger.pass("In-clinic appointments are available");		
	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+DocClinic+"')]")).click();
	ExtentLogger.pass("In-clinic appointment selected");
	Thread.sleep(5000);
	ExtentLogger.pass("Scrolling now..");
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
			+"(new UiSelector().text(\"Reschedule Appointment\"))").click();
	ExtentLogger.pass("Scrolling finished");
	ExtentLogger.pass("Clicked on Reschedule Appointment");
	Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+SlotInClinic+"\")"))).click();	                                     
	ExtentLogger.pass("Slot selected");
	Thread.sleep(5000);
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	
    ExtentLogger.pass("Patient selected from the list");
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Reschedule\"))").click();	        
	ExtentLogger.pass("In clinic appointment has been re-scheduled");

	}
	else
	{
		ExtentLogger.pass("No In-clinic appointment is available to Reschedule");
		Assert.fail("Marking this test failed");
	}
	}
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.CancelAndRescheduleAppointment)	
	@Test(priority=3,enabled=true,description="Cancel Video Consultation")
	public void CancelVideoConsultation() throws InterruptedException
	{		
	ExtentLogger.pass("Cancel an video consultation");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	ExtentLogger.pass("Clicked on Appointment section");	
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
			+ "scrollIntoView(new UiSelector().text(\"Video Consultation\"))").click();
	ExtentLogger.pass("Video consultation selected");
	Thread.sleep(10000);
	ExtentLogger.pass("Scrolling down...");
	TestUtil.ScrollingUntilEndOfPage();
    ExtentLogger.pass("Scrolling down finished");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Cancel Appointment\")"))).click();	
	ExtentLogger.pass("Clicked on Cancel Appointment Button");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Booked wrong clinic\")"))).click();
    ExtentLogger.pass("Reason:Booked wrong clinic selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Yes\")"))).click();	
	ExtentLogger.pass("Video consultation has been Cancelled");

}
	
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.CancelAndRescheduleAppointment)	
	@Test(priority=4,enabled=true,description="Reschedule Video Consultation")
	public void RescheduleVideoConsultation() throws InterruptedException
	{
	ExtentLogger.pass("Reschedule an Video Consultation");	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Appointments\")"))).click();
	ExtentLogger.pass("Clicked on Appointment section");
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
			+ "scrollIntoView(new UiSelector().text(\"Video Consultation\"))").click();
	ExtentLogger.pass("Video consultation is selected from Upcoming appointments section");		
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).click();
	ExtentLogger.pass("Video consultation selected");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Reschedule Appointment\")"))).click();
	ExtentLogger.pass("Clicked on Reschedule Appointment");
	Thread.sleep(10000);
	List<WebElement>AllSlots=driver.findElementsByClassName("android.widget.TextView");
	for (WebElement mobileElement : AllSlots) {
        if(mobileElement.getText().contains("AM"))
        {
            System.out.println(mobileElement.getText());
            System.out.println("inside if  AM selected");
        }
        else if(mobileElement.getText().contains("PM"))
        {
        	System.out.println(mobileElement.getText());
        	System.out.println("inside else   PM seleted");
        }
        
    }         
	
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().textContains(\""+SlotVideo+"\")"))).click();
	ExtentLogger.pass("Slot selected");
    driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Mohd Husain\")"))).click();	
    ExtentLogger.pass("Patient selected from the list");
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Submit\"))").click();	        
    ExtentLogger.pass("Submit button clicked");
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Reschedule\"))").click();	        
    ExtentLogger.pass("Video consultation has been re-scheduled");
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



/*
boolean a= driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).size()>0;
if(a==true) 
{
ExtentLogger.pass("Video consultation is selected from Upcoming appointments section");	
driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Video Consultation\")"))).click();
ExtentLogger.pass("Video consultation selected");
}
else
{
	ExtentLogger.pass("No Video consultation is available to cancel");
	Assert.fail("Marking this test failed");
}
*/

