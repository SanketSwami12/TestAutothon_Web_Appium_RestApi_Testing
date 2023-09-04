package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage{
public CheckOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(id ="first-name") WebElement fname;
@FindBy(id ="last-name") WebElement lname;
@FindBy(id ="postal-code") WebElement zipCode;
@FindBy(id ="continue") WebElement continueButton;
public void continueCheckout(String fn, String ln, String zc) {
	enterText(fname, fn);
	enterText(lname, ln);
	enterText(zipCode, zc);
	click(continueButton);
}
}
