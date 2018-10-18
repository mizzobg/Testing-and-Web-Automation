package WaitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitVar {
//	@FindBy (xpath = "/html/body/div[2]/div/h1")
//	private WebElement caption;
	public WebElement reText(WebDriver driver) {
		WebElement elem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/h1")));
		return elem;
	}
	public String reCaption(WebDriver driver) {
		String elem;
		return  elem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/h1"))).getText();
	}
}
