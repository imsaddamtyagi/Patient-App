package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;




 public class TestBase 
{
	
	
	public static AndroidDriver<WebElement> driver;
	public static Properties prop;
	public static Logger logger;


	public TestBase()
	{	
		
		logger = Logger.getLogger("PatientAppLogs");
		PropertyConfigurator.configure("Log4j.properties");

		try
		{					
			prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
			prop.load(ip);		
		} catch(FileNotFoundException e) {e.printStackTrace();
		} catch(IOException e){e.printStackTrace();
		}}
	
	public static void initialization() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		caps.setCapability("autoAcceptAlerts", true);
		caps.setCapability(MobileCapabilityType.APP,prop.getProperty("ApkPath")); 
				
		URL url = new URL("http:0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url,caps);
		 long LoginStartTime = System.nanoTime();	  // To calculate LoginTime.	
		logger.info("Launching Application with Apk version: "+prop.getProperty("ApkPath"));
		logger.info("Using Test Data Excel Sheet: "+prop.getProperty("ExcelName"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
		logger.info("Launching Application");
		
		driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Skip\")"))).click();
		logger.info("Clicked on Skip button to proceed for login");
		  WebDriverWait wait = new WebDriverWait(driver,40);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert =  driver.switchTo().alert(); alert.accept();
		  logger.info("Alert Accepted");
		  
	       driver.findElement(By.className("android.widget.EditText")).click();
	       driver.findElement(By.className("android.widget.EditText")).sendKeys(prop.getProperty("Phone"));
	       logger.info("Phone number entered");
		   driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Request OTP\")"))).click();
		   logger.info("Clicked on Request OTP");
		   Thread.sleep(30000);
		   logger.info("OTP entered");
			/*
			 * Robot robot = new Robot();
			 * robot.keyPress(KeyEvent.VK_5); Thread.sleep(2000);
			 * robot.keyPress(KeyEvent.VK_6); Thread.sleep(2000);
			 * robot.keyPress(KeyEvent.VK_1); Thread.sleep(2000);
			 * robot.keyPress(KeyEvent.VK_3); Thread.sleep(2000);
			 */	   
		   driver.navigate().back();
		   Thread.sleep(2000);
		   driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"Verify Number\")"))).click();
		   logger.info("Clicked on Verify number");

			  WebDriverWait waits = new WebDriverWait(driver,40);
			  waits.until(ExpectedConditions.alertIsPresent()); 
			  Alert alerts =  driver.switchTo().alert(); 
			  alerts.accept();
			  logger.info("Alert Accepted");
			  long LoginEndTime = System.nanoTime();
			  long durationLogin = (LoginEndTime - LoginStartTime);
			  logger.info("Time taken in App Launch and login in Emulator: "+Duration.ofNanos(durationLogin).toMinutes()+" Minutes");   
			  Thread.sleep(15000);
			  logger.info("Login Successfull");	 		
		
	}
	
	

}
