package Elements;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.PageFactory;
public class findElements {

	public WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	
	@Test
	public void searchText	() throws Exception  {
		 	driver.get("http://thedemosite.co.uk/");
		 	userCreation newUser = PageFactory.initElements(driver, userCreation.class);
			userLogin login = PageFactory.initElements(driver, userLogin.class);
			
			newUser.createUser("561461616161","561461616161");
			login.loginUser("561461616161","561461616161");
			assertEquals("Failed to login","**Successful Login**", login.getResult().getText());	
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
