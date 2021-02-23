package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestUtil extends TestBase {

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\"+prop.getProperty("ExcelName");
	                                                     
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {e.printStackTrace();}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
		data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest(String TestName) throws IOException {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		logger.info("Taking Screenshot");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("TestScreenshot\\"+TestName+generatedString+".png"));
		logger.info("Screenshot captured");
	}

	
    public static void ScrollingUntilEndOfPage()
    {
	@SuppressWarnings("rawtypes")
	TouchAction  action =new TouchAction(driver);	
	Dimension size	=driver.manage().window().getSize();
	int width=size.width;
	int height=size.height;				
	int middleOfX=width/2;
	int startYCoordinate= (int)(height*.7);
	int endYCoordinate= (int)(height*.2);							
	action.press(PointOption.point(middleOfX, startYCoordinate))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();		
	}


}
