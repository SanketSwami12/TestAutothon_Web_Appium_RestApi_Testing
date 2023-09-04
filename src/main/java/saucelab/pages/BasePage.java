package saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
public WebDriver driver;
public WebDriverWait wait;

public BasePage(WebDriver driver) {
	this.driver=driver;
	wait = new WebDriverWait(driver, 20);
}

public void waitForElementToBeVisible(WebElement element) {
	try {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(element));
	} catch (Exception e) {
		System.out.println(e.toString());
	}
}
public void click(WebElement element) {
	try {
		waitForElementToBeVisible(element);
		element.click();
	} catch (Exception e) {
		System.out.println(e.toString());
	}
	
	
}
public void enterText(WebElement element, String text) {
	try {
		waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(text);
	} catch (Exception e) {
		System.out.println(e.toString());
	}
}
public void selectFromDropdown(WebElement element, String value) {
	try {
		waitForElementToBeVisible(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	} catch (Exception e) {
		System.out.println(e.toString());
	}
	}
}

