package TheDemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userLogin {
	@FindBy (how =How.PARTIAL_LINK_TEXT, using ="4. Login")										// find the element by searching for string
	private WebElement logUser;																	// assign the element to var addUser
	@FindBy (name = "username")																	// find the element by searching for its name
	private WebElement userName;																// assign the element to var userName
	@FindBy (name = "password")																	// find the element by searching for its name
	private WebElement password;																// assign the element to var password
	@FindBy (name = "FormsButton2")																// find the element by searching for its name
	private WebElement submitBtn;																// assign the element to submitBtn
	@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")	// find the element using the xpath
	private WebElement message;																	// assign the element to message
	
	public void loginUser(String user, String pass) {
		logUser.click();		 	// click on the add user element
		userName.sendKeys(user); 	// input the user string in the userName element
		password.sendKeys(pass);	// input the password string in the password element
		submitBtn.click();			// Click on the submitBtn element to submit the file.
	}
	
	public String getResult() {
		return message.getText();		//Returns the Element containing the pass or fail message
	}
}
