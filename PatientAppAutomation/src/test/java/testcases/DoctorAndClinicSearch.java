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
import io.appium.java_client.MobileElement;
import util.TestUtil;

public class DoctorAndClinicSearch extends TestBase {
	
	
	static long startTime;
	static long endTime;
	
	  String DocForInClinic ="Simanto";
	  String DocInitials= "IDrts-987";
	  
	  String ClinicHospital="fortune hospital";
	  String ClinicRealName="fortune hospital";

	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.DoctorAndClinicSearch)
	@Test(priority=1,enabled=false,description="Verify Doctor Search")
	public void VerifyDoctorSearch() throws InterruptedException 
	{
	
		  ExtentLogger.pass("Verifying Doctor Search");
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
      Thread.sleep(5000);
      Actions action = new Actions(driver);
      action.sendKeys(Doc).perform();
      
		    WebDriverWait wait3 = new WebDriverWait(driver,30);
		    WebElement ActualAcc=  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+DocInitials+"']")));
		    ActualAcc.click();             
		    ExtentLogger.pass("Doctor Selected");
			Thread.sleep(5000);
			WebDriverWait wait4 = new WebDriverWait(driver,30);
		    WebElement ActualAcc4=  wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+DocInitials+"']")));
		    ActualAcc4.click();  
		    ExtentLogger.pass("Doctor Profile clicked");
}
	
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.DoctorAndClinicSearch)
	@Test(priority=2,enabled=true,description="Verify Clinic Search")
	public void VerifyClinicSearch() throws InterruptedException 
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
    
    Thread.sleep(20000);
    
    List<WebElement> buttons1 = driver.findElements(By.className("android.widget.TextView"));
	  for(WebElement button1 : buttons1){
	  if(button1.getText().startsWith("Clinics")){
	  button1.click(); 
	  button1.click(); 
	  ExtentLogger.pass("Clinic Button Clicked"); 
	  }}
    
	  Thread.sleep(15000);
	  
	  
	  List<WebElement> buttons2 = driver.findElementsByClassName("android.widget.TextView");
	  for(WebElement button2 : buttons2){
	  if(button2.getText().trim().equals(ClinicRealName)){
		  button2.click(); 
	  }
	  break;
	  }
    
	  ExtentLogger.pass("Clinic Profile clicked..."); 
		
	
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
	    // driver.quit();  
	    }
	    

}
