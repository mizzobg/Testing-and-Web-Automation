package TheDemoSite;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class findElements {
ExtentReports extent = new ExtentReports(constants.Path_Reports+constants.File_Report, true);

ExtentTest test;

	public WebDriver driver = null;
	
	/**
	 * The drive loading before test execution and start test logging
	 */
	@Before
	public void setup() {
		test = extent.startTest("Start the test and initialise the Driver");
//		System.setProperty("webdriver.gecko.driver", constants.Firefox_Driver);
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void loginTest	() throws Exception  {
	
		FileInputStream file = new FileInputStream(constants.Path_TestData+constants.File_TestData);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		driver.get(constants.website);
		test.log(LogStatus.INFO, "Browser started and Page loaded");
		userCreation newUser = PageFactory.initElements(driver, userCreation.class);
		userLogin login = PageFactory.initElements(driver, userLogin.class);
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFCell cell = sheet.getRow(i).getCell(0);
			String userCell = cell.getStringCellValue();
			cell = sheet.getRow(i).getCell(1);
			String passCell = cell.getStringCellValue();
			cell = sheet.getRow(i).getCell(2);
			String expectedCell = cell.getStringCellValue();
			XSSFCell cell2 = sheet.getRow(i).createCell(3);
			cell2.setCellType(CellType.STRING);
//			XSSFCell cell2 = sheet.getRow(i).getCell(3);

			newUser.createUser(userCell, passCell); 				 // Inputing for user creation using the function and passing it the values for user and pass
			test.log(LogStatus.INFO, "User login and password Created");
			
			login.loginUser(userCell, passCell); 					 // Using the function to login and passing the values for user and pass
			test.log(LogStatus.INFO, "User login and password Entered in Login");
			
			if (login.getResult().equals(expectedCell)) { 			 // Check function for the report
				test.log(LogStatus.PASS, "verify the login successful");		 // Returns a pass
				cell2.setCellValue(expectedCell);
			} else {
				test.log(LogStatus.FAIL, "verify the login Failed");			 // Returns a fail
				cell2.setCellValue("Failed test");
			}
			FileOutputStream end = new FileOutputStream(constants.Path_TestData+constants.File_TestData);
			workbook.write(end);
		    end.close();
		    
		    assertEquals("Login Check",constants.Expected_Results, login.getResult());// Runs the test check to using function and comparing the text
		}
		
		
	}
	/**
	 * Driver offloading / teardown (closing the browser) after test execution.
	 */
	@After
	public void tearDown() {
		driver.quit();			//Stops the driver/browser
		extent.endTest(test);	//Ends the test - test
		extent.flush();			//Send results to report
	}
	
}
