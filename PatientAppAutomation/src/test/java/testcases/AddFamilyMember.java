package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class AddFamilyMember extends TestBase {
	
	static long startTime;
	static long endTime;
	

	@BeforeMethod      
	public void setUp() throws MalformedURLException, InterruptedException   
	{
		startTime = System.nanoTime();
		initialization();             
		} 
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.AddFamilyMember)
	@Test(enabled=true,dataProvider="getDataFamily",description="Add family member from side menu")
	public void AddFamily(String FirstAndMiddleName,String LastName,String DOB,String Gender,String Relation) throws AWTException, InterruptedException
	{
	ExtentLogger.pass("Adding Family member in the App");
	driver.findElement(By.className("android.widget.ImageView")).click();
	ExtentLogger.pass("Clicked on side menu");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Family\")"))).click();
	ExtentLogger.pass("Clicked on Add family icon");
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys(FirstAndMiddleName);	   
	ExtentLogger.pass("First name and Middle name entered: "+FirstAndMiddleName);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")).sendKeys(LastName);	   
	ExtentLogger.pass("Last name entered: "+LastName);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")).sendKeys(DOB);	   
	ExtentLogger.pass("DOB entered: "+DOB);

	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+Gender+"\")"))).click();
	       Thread.sleep(2000);  
	       ExtentLogger.pass("Gender Selected: "+Gender);
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"\")"))).click();
	       ExtentLogger.pass("Selecting Relation from dropdown");	       
		   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
		   + "scrollIntoView(new UiSelector().text(\""+Relation+"\").instance(0))").click();
		   
		   ExtentLogger.pass("Relation selected: "+Relation);
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Patient\")"))).click();
	       ExtentLogger.pass("Family member Added: "+FirstAndMiddleName+" "+LastName);

	       }
	
	
	@FrameworkAnnotation(author= {"Husain"},category = CategoryType.AddFamilyMember)
	@Test(priority=2,enabled=true,dataProvider="getDataFamily",description="Add Profile Pic in Patient Profile")
	public void AddProfilePic(String FirstAndMiddleName,String LastName,String DOB,String Gender,String Relation) throws AWTException, InterruptedException
	{
		 String[] sub= FirstAndMiddleName.split(" ");	 
		 String str1= sub[0].substring(0,1);
	     String str2= sub[1].substring(0,1);
	     String str3= LastName.substring(0,1);	     
	     String initials= str1+str2+str3;
	     
	        ExtentLogger.pass("Add Profile Pic in Family member");
			driver.findElement(By.className("android.widget.ImageView")).click();
			ExtentLogger.pass("Clicked on side menu");
			Thread.sleep(5000);
			driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+initials+"\")"))).click();	
			ExtentLogger.pass("Clicked on patient profile");
			Thread.sleep(3000);
			driver.findElement(By.xpath ("//android.widget.ImageView[@bounds='[226,423][287,481]']")).click();
			ExtentLogger.pass("Clicked on side menu");
			Thread.sleep(3000);
			driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Upload from gallery\")"))).click();
			ExtentLogger.pass("Clicked on Upload from gallery");
			

			  WebDriverWait wait = new WebDriverWait(driver,20);
			  wait.until(ExpectedConditions.alertIsPresent()); 
			  Alert alert =  driver.switchTo().alert(); 
			  alert.accept();
			  ExtentLogger.pass("Alert Accepted");
			  Thread.sleep(7000);
		      driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_mime_lg\")"))).click();

				
				Thread.sleep(7000);
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Crop\"]")).click();
				ExtentLogger.pass("Image cropped ");
				Thread.sleep(7000);
				driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Done\")"))).click();
				ExtentLogger.pass("Image Applied to the profile");
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



/*
driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"First & Middle Name\")"))).get(0).click();
	  Robot robot = new Robot(); 
	  Thread.sleep(3000); 
	  robot.keyPress(KeyEvent.VK_S);
	  robot.keyPress(KeyEvent.VK_A); 
	  robot.keyPress(KeyEvent.VK_D);
	  robot.keyPress(KeyEvent.VK_I);
	  robot.keyPress(KeyEvent.VK_K);
	  Thread.sleep(2000); 
   System.out.println("Name entered");
   driver.navigate().back();           
	  Thread.sleep(2000);
	  	  
	   driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Last Name\")"))).click();
	   Robot robot2 = new Robot(); 
	   robot2.keyPress(KeyEvent.VK_T);
	   robot2.keyPress(KeyEvent.VK_Y); 
	   robot2.keyPress(KeyEvent.VK_A);
	   robot2.keyPress(KeyEvent.VK_G);
	   robot2.keyPress(KeyEvent.VK_I);
		  Thread.sleep(2000); 
       System.out.println("Last Name entered");
       driver.navigate().back();           
		  Thread.sleep(4000); 
		  
		  					   	  
	 driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Date of Birth\")"))).click();
	  Robot robotB = new Robot(); 

	 
	        robotB.keyPress(KeyEvent.VK_0);
			robotB.keyPress(KeyEvent.VK_4);
			robotB.keyPress(KeyEvent.VK_SLASH);  
			robotB.keyPress(KeyEvent.VK_0);
			robotB.keyPress(KeyEvent.VK_4);
			robotB.keyPress(KeyEvent.VK_SLASH); 
			robotB.keyPress(KeyEvent.VK_1);
			robotB.keyPress(KeyEvent.VK_9);
			Thread.sleep(1000);
			robotB.keyPress(KeyEvent.VK_9);
			robotB.keyPress(KeyEvent.VK_1);
		    Thread.sleep(2000); 
         System.out.println("DOB  entered");
         driver.navigate().back();           
	    	Thread.sleep(2000); 
*/