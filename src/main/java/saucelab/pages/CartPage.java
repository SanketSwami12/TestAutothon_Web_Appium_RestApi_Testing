package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
	@FindBy(xpath = "//*[text()='Your Cart']") WebElement yourCarText;
@FindBy(id="checkout") WebElement checkout;
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public String fetchText() {
		return yourCarText.getText();
	}
public void clikOnchechout() {
	click(checkout);
}
}
