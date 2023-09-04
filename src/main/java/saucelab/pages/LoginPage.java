package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(id ="user-name")public WebElement username;
	@FindBy(id ="password")public WebElement password;
	@FindBy(id ="login-button")public WebElement loginButton;
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void loginToApplication(String uname, String pwd) {
		try {
			enterText(username, uname);
			enterText(password, pwd);
			click(loginButton);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
