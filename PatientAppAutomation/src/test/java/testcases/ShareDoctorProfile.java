package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import util.TestUtil;

public class ShareDoctorProfile extends TestBase {
	
	static long startTime;
	static long endTime;
	
    String DocForInClinic ="Simanto";   
    String DocCode =  "IDrts-987";

	  String ClinicHospital="Fortune Hospital";
	  String ClinicRealName="Fortune Hospital";


	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.ShareDoctorProfile)
	@Test(enabled=true,priority=1,description="Share Doctor Profile")
	public void ShareDoctorProfileTest() throws InterruptedException
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
	    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+DocCode+"']")));
	    ActualAcc.click();
	    ExtentLogger.pass("Doctor Selected");
	    Thread.sleep(7000);
	    
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+DocForInClinic+"\")"))).click();	
	    ExtentLogger.pass("Doctor Profile Selected");	  
	    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView")).click();
	    ExtentLogger.pass("Share Button Clicked");
	
	}
	

	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.ShareDoctorProfile)
	@Test(enabled=true,priority=2,description="Share Doctor Profile from clinic")
	public void ShareDoctorProfileInClinicTest() throws InterruptedException
	{
		  ExtentLogger.pass("Verifying Clinic Search");
		  List<WebElement> buttons = driver.findElementsByClassName("android.widget.TextView");
		  for(WebElement button : buttons){
		  if(button.getText().trim().equals("Add Doctor")){
		  button.click(); 
		  ExtentLogger.pass("Add Doctor button clicked..."); 
		  Thread.sleep(7000);
		  }}
		  		 
  ExtentLogger.pass("Searching Clinic");
  String Doc=ClinicHospital;
  MobileElement mobileElement=(MobileElement)driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));       
  mobileElement.click();
  Thread.sleep(5000);
  Actions action = new Actions(driver);
  action.sendKeys(Doc).perform();
  
  Thread.sleep(15000);
  
  List<WebElement> buttons1 = driver.findElements(By.className("android.widget.TextView"));
	  for(WebElement button1 : buttons1){
	  if(button1.getText().startsWith("Clinics")){
	  button1.click(); 
	  button1.click(); 
	  ExtentLogger.pass("Clinic Button Clicked"); 
	  }}
  
	  Thread.sleep(10000);
	  
	  
	  List<WebElement> buttons2 = driver.findElementsByClassName("android.widget.TextView");
	  for(WebElement button2 : buttons2){
	  if(button2.getText().trim().equals(ClinicRealName)){
		  button2.click(); 
	  }
	  break;
	  }
  
	  ExtentLogger.pass("Clinic Profile clicked..."); 
		
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")).click();	  
 	   ExtentLogger.pass("Doctor Profile clicked..."); 
	   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")).click();
	   ExtentLogger.pass("Doctor Profile Selected for sharing..."); 
	   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView")).click();
	   ExtentLogger.pass("Sharing Doctor profile via other medium..."); 


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
