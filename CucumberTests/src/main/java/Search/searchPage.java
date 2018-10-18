package Search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage {
	@FindBy(id = "sb_form_q")
	private WebElement sBar;
//	@FindBy(id = "sb_form_go")
//	private WebElement sBtn;
	
	public void search(String keyword) {
		sBar.sendKeys(keyword);
		sBar.submit();
	}
}
