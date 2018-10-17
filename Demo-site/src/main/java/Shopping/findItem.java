package Shopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class findItem {
	@FindBy(xpath ="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[6]/div/div[1]/div/a[1]")
	private WebElement dress;
	
	public void select() {
		dress.click();
	}
}
