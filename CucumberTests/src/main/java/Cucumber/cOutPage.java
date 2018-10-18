package Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cOutPage {
	@FindBy(xpath ="/html/body/div/div/div[1]/div/div[1]/div/div/form/fieldset[1]/legend")
	private WebElement message;
	
	public String cOutMessage(WebDriver driver) {
		return driver.getCurrentUrl();
		
	}
	public String cOutMessage2() {
	return message.getText();
	}
}
