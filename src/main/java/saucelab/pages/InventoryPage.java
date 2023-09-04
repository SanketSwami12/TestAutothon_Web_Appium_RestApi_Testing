package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
	@FindBy(id="react-burger-menu-btn") WebElement menu;
	@FindBy(id="about_sidebar_link") WebElement about;
	@FindBy(xpath = "//select") WebElement productSort;
	@FindBy(xpath = "//*[text()='Add to cart']") WebElement addTocart;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement cart;
	
	public InventoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAbout() {
		click(menu);
		click(about);
	}
	public void sortProduct(String option) {
		selectFromDropdown(productSort, option);
	}
	public void addToCart() {
		click(addTocart);
		click(cart);
	}

}
