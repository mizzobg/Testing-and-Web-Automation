package Shopping;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class shoppingTest {
	ExtentReports extent = new ExtentReports(constants.Path_Reports+constants.Report, true);

	ExtentTest test;

		public WebDriver driver = null;
		/**
		 * The drive loading before test execution and start test logging
		 */
		@Before
		public void setup() {
			test = extent.startTest("Start the test and initialise the Driver");
//			System.setProperty("webdriver.gecko.driver", constants.Firefox_Driver);
//			driver = new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
			driver = new ChromeDriver();
		}

		@Test
		public void runShoppingTest	() throws Exception  {
			driver.get(constants.website);
		 	test.log(LogStatus.INFO, "Browser started and Page loaded");
		 	searchMe newSearch = PageFactory.initElements(driver, searchMe.class);
			findItem find = PageFactory.initElements(driver, findItem.class);
			verifyItem verify = PageFactory.initElements(driver, verifyItem.class);
			
			newSearch.enterSearch("Dress"); 										// Inputing for user creation using the function and passing it the values for user and pass
			test.log(LogStatus.INFO, "Search located, keyword input and search executed");// Testing log for executed actions
			find.select();															// Using the function to find and select the dress
			test.log(LogStatus.INFO, "Find the dress and click on it");
			if (verify.vItem().equals("Faded Short Sleeve T-shirts")) {				// Check function for the report
				test.log(LogStatus.PASS, "Correct Item Found");						// Returns a pass to report
			}
			else {
				test.log(LogStatus.FAIL, "Incorrect Item Found");					// Returns a fail to report

			}
			assertEquals("Check if correct dress","Faded Short Sleeve T-shirts", verify.vItem());// Runs the test check to using function and comparing the text
			
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
