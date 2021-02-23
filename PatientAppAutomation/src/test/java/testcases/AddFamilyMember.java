package testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
	
	
	@Test(dataProvider="getDataFamily")
	public void AddFamily(String FirstAndMiddleName,String LastName,String DOB,String Gender,String Relation) throws AWTException, InterruptedException
	{
    System.out.println("Adding Family member in the App");
	driver.findElement(By.className("android.widget.ImageView")).click();
	System.out.println("Clicked on side menu");
	driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Family\")"))).click();
	System.out.println("Clicked on Add family icon");
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys(FirstAndMiddleName);	   
	System.out.println("First name and Middle name entered: "+FirstAndMiddleName);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText")).sendKeys(LastName);	   
	System.out.println("Last name entered: "+LastName);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText")).sendKeys(DOB);	   
	System.out.println("DOB entered: "+DOB);

	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\""+Gender+"\")"))).click();
	       Thread.sleep(2000);  
	       System.out.println("Gender Selected: "+Gender);
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"\")"))).click();
	       System.out.println("Selecting Relation from dropdown");	       
		   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
		   + "scrollIntoView(new UiSelector().text(\""+Relation+"\"))").click();
	       System.out.println("Relation selected: "+Relation);
	       driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Add Patient\")"))).click();
	       System.out.println("Patient Added");
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
	     System.out.println("Ending Session");
	     Thread.sleep(2000);
	     if (testResult.getStatus() == ITestResult.FAILURE)
	     {
	    	 String FailedTestName= testResult.getMethod().getMethodName();
	         System.out.println("Failed TestName: "+FailedTestName);
	         TestUtil.takeScreenshotAtEndOfTest("Failed"+FailedTestName);
	     }
	     else if (testResult.getStatus() == ITestResult.SUCCESS) 
	         {
	        	 String PassedTestName= testResult.getMethod().getMethodName();
	             System.out.println("Passed TestName: "+PassedTestName);
		         TestUtil.takeScreenshotAtEndOfTest("Passed"+PassedTestName);
	         }	
	     
	     endTime= System.nanoTime();
	     long duration = (endTime - startTime);
	     System.out.println("Time taken by test: "+Duration.ofNanos(duration).toMinutes()+" Minutes");   
         Thread.sleep(5000);
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