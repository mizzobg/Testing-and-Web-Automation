package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Run {

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement searchbox;
	
	public void search(String text) throws InterruptedException {
			searchbox.sendKeys(text);
		searchbox.submit();
	}

}
