package Cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepExecution {
	public WebDriver driver =null;
	
	ExtentReports extent = new ExtentReports(constants.Path_Reports+constants.File_Report, false);
	ExtentTest test;
	
	@Before
	public void setup() {
	test = extent.startTest("Start the test and initialise the Driver");
	System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
	driver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		driver.quit();			//Stops the driver/browser
		extent.endTest(test);	//Ends the test - test
		extent.flush();			//Send results to report
	}
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		test.log(LogStatus.INFO, "Browser loaded landing page");
		driver.get(constants.website);
		
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page(){
		test.log(LogStatus.INFO, "Clicked and navigated to menu page");
		homePage goTo = PageFactory.initElements(driver, homePage.class);
		goTo.menu();
		
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products(){
		menuPage check = PageFactory.initElements(driver, menuPage.class);
		if (check.getTea().equals(constants.base)) {
			test.log(LogStatus.INFO, "Browser loaded product page");
		}
		else {
			test.log(LogStatus.INFO, "Browser did not load the product page");
		}
		assertEquals("Menu Page",constants.base, check.getTea());
	}

	@When ("^I click the checkout button$")
	public void i_click_the_checkout_button(){
		homePage goTo = PageFactory.initElements(driver, homePage.class);
		goTo.cOut();
		test.log(LogStatus.INFO, "Clicked on checkout");

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page(){
		cOutPage check = PageFactory.initElements(driver, cOutPage.class);
		
		if (check.cOutMessage(driver).equals(constants.cOut)&&check.cOutMessage2().equals(constants.cOut2)) {
			test.log(LogStatus.PASS, "Browser loaded checkout page");
		}
		else {
			test.log(LogStatus.FAIL, "Browser did not load the checkout page");
		}
		assertEquals("checkout page Url check",constants.cOut, check.cOutMessage(driver));
		assertEquals("checkout page Text check",constants.cOut2, check.cOutMessage2());
	}
}
