package Search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultsPage {
	@FindBy(id = "sb_form_q")
	private WebElement result;
	
	public String result() {
		return result.getAttribute("value");
	}
}
