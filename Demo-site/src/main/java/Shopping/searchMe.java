package Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchMe {
	@FindBy (id = "search_query_top")
	private WebElement searchBox;
	@FindBy (name = "submit_search")
	private WebElement submitBtn;
	
	public void enterSearch(String keyword) {
		searchBox.sendKeys(keyword);
		submitBtn.click();
	}
}
