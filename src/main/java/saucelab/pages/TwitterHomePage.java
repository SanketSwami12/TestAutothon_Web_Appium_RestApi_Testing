package saucelab.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;

public class TwitterHomePage extends BasePage{
public TwitterHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//*[@aria-label='Close']") WebElement closeButton;
@FindBy(xpath = "//*[@data-testid='tweetTextarea_0' or @aria-label='Tweet text']") WebElement postTextbox;
@FindBy(xpath = "//*[text()='Home']") WebElement homeLogo;
@FindBy(xpath = "//*[text()='Post']//ancestor::*[@role='button']") WebElement postButton;
@FindBy(xpath = "//*[text()='text']//ancestor::*[@aria-label='Timeline: Search timeline']") WebElement post1;
@FindBy(xpath = "//input[@placeholder='Search']") WebElement searchTextbox;
@FindBy(xpath = "//*[@data-testid='searchSpellingSuggestionLink']") WebElement searchSpellingSuggestionLink;
@FindBy(xpath = "//a[@aria-label='Search and explore']")
public WebElement searchnExploreButon;

public void clickOnClose() {
	if (closeButton.isDisplayed()) {
		click(closeButton, "close button");		
	}
}
public boolean isHomeLogoDisplayed() {
	return homeLogo.isDisplayed();
}

public void createPost(String post) {
	enterText(postTextbox, post, "Entering Post");
	click(postButton, "post button");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	clickOnClose();
}
public void clickonsearchSpellingSuggestionLink() {
	if (searchSpellingSuggestionLink.isDisplayed()) {
		click(searchSpellingSuggestionLink, "searchSpellingSuggestionLink");
	}
}
public void searchPost(String post) throws InterruptedException {
	click(searchnExploreButon, "");
	enterText(searchTextbox, post, "post1");
	searchTextbox.sendKeys(Keys.ENTER);
	//clickonsearchSpellingSuggestionLink();
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		String path =System.getProperty("user.dir")+"/screenshot/"+post+".jpg";
		FileUtils.copyFile(screenshotFile, new File(path));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
