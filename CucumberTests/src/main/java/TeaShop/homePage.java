package TeaShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	@FindBy(xpath ="/html/body/div/div/div[1]/div/div[13]/div/ul/li[3]/a")
	private WebElement menu;
	@FindBy(xpath ="/html/body/div/div/div[1]/div/div[13]/div/ul/li[5]/a")
	private WebElement cOutBtn;
	public void menu() {
		menu.click();
	}
	public void cOut() {
		cOutBtn.click();
	}
}
