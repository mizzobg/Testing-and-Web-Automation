package Search;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepExecution {
	public WebDriver driver =null;
	String tempSearch= "";
//	ExtentReports extent = new ExtentReports(constants.Path_Reports+constants.File_Report, false);
//	ExtentTest test;
	@Before
	public void setup() {
//	test = extent.startTest("Start the test and initialise the Driver");
	System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
	driver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		driver.quit();			//Stops the driver/browser
//		extent.endTest(test);	//Ends the test - test
//		extent.flush();			//Send results to report
	}
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1){
		driver.get(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1){
		searchPage result = PageFactory.initElements(driver, searchPage.class);
		result.search(arg1);
		tempSearch=arg1;
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search(){
		resultsPage result = PageFactory.initElements(driver, resultsPage.class);
		
		assertEquals("checkout page Text check",tempSearch, result.result());
//		Assert.assertTrue(result.result().contains(tempSearch),"Search missmatch");
	}
}
