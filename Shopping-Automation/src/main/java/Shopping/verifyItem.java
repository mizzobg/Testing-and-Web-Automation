package Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class verifyItem {
	@FindBy(xpath ="/html/body/div/div[2]/div/div[4]/div/div/div/div[3]/h1")
	private WebElement name;
	
	public String vItem() {
		return name.getText();
	}
	
}
