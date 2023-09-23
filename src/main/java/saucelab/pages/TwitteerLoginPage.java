package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;

public class TwitteerLoginPage extends BasePage{
public TwitteerLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//*[text()='Sign in']//ancestor::a") WebElement signIn;
@FindBy(xpath = "//input[@autocomplete='username']") WebElement username;
@FindBy(xpath = "//*[text()='Next']//ancestor::*[@role='button']") WebElement unameNext;
@FindBy(xpath = "//input[@type='password']") WebElement password;
@FindBy(xpath = "//*[text()='Log in']//ancestor::*[@role='button']") WebElement logIn;

public void loginToX(String unmae, String Pass) {
	scrollToElement(signIn);
	click(signIn, "Clicking on sign in button..");
	enterText(username,unmae, "Entering username");
	click(unameNext, "Clicking on next button");
	enterText(password, Pass, "Entering Password..");
	click(logIn, "Clicking on login button");
}

}
