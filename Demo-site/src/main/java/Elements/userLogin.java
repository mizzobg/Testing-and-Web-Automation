package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userLogin {
	@FindBy (how =How.PARTIAL_LINK_TEXT, using ="4. Login")
	private WebElement logUser;
	@FindBy (name = "username")
	private WebElement userName;
	@FindBy (name = "password")
	private WebElement password;
	@FindBy (name = "FormsButton2")
	private WebElement submitBtn;
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement message;
	
	public void loginUser(String user, String pass) {
		logUser.click();
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
	}
	
	public WebElement getResult() {
		return message;
	}
}
