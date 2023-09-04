package saucelab.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverview extends BasePage{
@FindBy(xpath="//*[text()='Checkout: Overview']") WebElement checoutTExtover;
@FindBy(xpath = "//*[@class='summary_info_label summary_total_label']") WebElement total;
	public CheckOutOverview(WebDriver driver) {
		super(driver);
	PageFactory.initElements(driver, this);
	}
	public String fetchtext() {
		return checoutTExtover.getText();

	}
	public boolean validateTotalPricePattern() {
		String totaPricetext = total.getText();
		String extractingTotal = totaPricetext.replace("Total: ","");
		String pricePattern = "\\$\\d{1,2}\\.\\d{2}";
		Pattern pattern =Pattern.compile(pricePattern);
		Matcher matcher = pattern.matcher(extractingTotal);
		return matcher.matches();
	}
}
