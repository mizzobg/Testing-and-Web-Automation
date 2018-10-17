package Paint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class paintTest {

	public WebDriver driver = null;
	/**
	 * The drive loading before test execution
	 */
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	/**
	 * Driver offloading / teardown (closing the browser) after test execution.
	 */
	@After
	public void tearDown() {
		driver.quit();
	}
	/**
	 * The function that controls the mouse clicks and moves it to write out my name.
	 */
	@Test
	public void writeName() {
		driver.get("https://www.youidraw.com/apps/painter/");
		Actions action= new Actions(driver);

		action.moveByOffset(300,300).clickAndHold().moveByOffset(0,200).release().moveByOffset(0,-200).clickAndHold().moveByOffset(80,80).moveByOffset(80,-80).moveByOffset(0,200).release().perform();   // The letter M
		action.moveByOffset(20,0).clickAndHold().moveByOffset(80,-200).moveByOffset(80,200).release().moveByOffset(-40,-100).clickAndHold().moveByOffset(-80,0).release().moveByOffset(120,100).perform();		// The letter A
		action.moveByOffset(20,0).clickAndHold().moveByOffset(0,-200).moveByOffset(100,0).moveByOffset(0,100).moveByOffset(-100,0).moveByOffset(100,100).release().perform();		// The letter R
		action.moveByOffset(70,0).clickAndHold().moveByOffset(0,-200).moveByOffset(-50,0).release().moveByOffset(50,0).clickAndHold().moveByOffset(50,0).release().perform();		// The letter T
		action.moveByOffset(20,200).clickAndHold().moveByOffset(0,-200).release().perform(); // The letter I
		action.moveByOffset(20,200).clickAndHold().moveByOffset(0,-200).moveByOffset(110,200).moveByOffset(0,-200).release().perform(); // The letter N
	}
}
