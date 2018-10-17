package TheDemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userCreation {
	@FindBy (how =How.PARTIAL_LINK_TEXT, using ="3. Add a User")	// find the element by searching for string
	private WebElement addUser;										// assign the element to var addUser
	@FindBy (name = "username")										// find the element by searching for its name
	private WebElement userName;									// assign the element to var userName
	@FindBy (name = "password")										// find the element by searching for its name
	private WebElement password;									// assign the element to var password
	@FindBy (name = "FormsButton2")									// find the element by searching for its name
	private WebElement submitBtn;									// assign the element to submitBtn
	public void createUser(String user, String pass) {
		addUser.click();		 	// click on the add user element
		userName.sendKeys(user); 	// input the user string in the userName element
		password.sendKeys(pass);	// input the password string in the password element
		submitBtn.click();			// Click on the submitBtn element to submit the file.
	}
}
