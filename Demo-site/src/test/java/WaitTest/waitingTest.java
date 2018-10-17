package WaitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class waitingTest {
	ExtentReports extent = new ExtentReports(constants.Path_Reports+constants.Report, true);
	ExtentTest test;
	public WebDriver driver = null;
	/**
	 * The drive loading before test execution
	 */
	@Before
	public void setup() {
		test = extent.startTest("Start the test and initialise the Driver");
		System.setProperty("webdriver.gecko.driver", constants.Firefox_Driver);
		driver = new FirefoxDriver();
	}
	/**
	 * Driver offloading / teardown (closing the browser) after test execution.
	 */
	@After
	public void tearDown() {
		driver.quit();
		extent.endTest(test);	//Ends the test - test
		extent.flush();			//Send results to report
	}
	/**
	 * The function that controls the mouse clicks and moves it to write out my name.
	 */
	@Test
	public void writeName() {
		driver.get(constants.website);
		test.log(LogStatus.INFO, "Browser started and Page loaded");
		
		waitVar message = new waitVar();
		message.reText(driver);
		test.log(LogStatus.INFO, "Item located after wait");
		
		String text = driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
		test.log(LogStatus.INFO, "Id parced from element to text");
		
		if (text.equals(constants.message)) {
			test.log(LogStatus.PASS, "Message located");		 // Returns a pass
			
		} else {
			test.log(LogStatus.FAIL, "Message not found");			 // Returns a fail
		}
		assertEquals("Check if correct message",constants.message, text);
	}
		
}
