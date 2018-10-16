package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userCreation {
	@FindBy (how =How.PARTIAL_LINK_TEXT, using ="3. Add a User")
	private WebElement addUser;
	@FindBy (name = "username")
	private WebElement userName;
	@FindBy (name = "password")
	private WebElement password;
	@FindBy (name = "FormsButton2")
	private WebElement submitBtn;
	public void createUser(String user, String pass) {
		addUser.click();
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
	}
}
