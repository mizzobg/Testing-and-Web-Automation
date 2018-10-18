package Cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class menuPage {
	@FindBy(xpath ="/html/body/div/div/div[1]/div/div[14]/div/p/span/span/strong")
	private WebElement tea;
	public String getTea() {
		return tea.getText();
	}
}
