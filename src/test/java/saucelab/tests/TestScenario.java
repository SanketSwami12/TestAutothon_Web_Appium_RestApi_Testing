package saucelab.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import saucelab.pages.CartPage;
import saucelab.pages.CheckOutOverview;
import saucelab.pages.CheckOutPage;
import saucelab.pages.InventoryPage;
import saucelab.pages.LoginPage;

public class TestScenario extends TestBase {
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckOutPage checkOutPage; 
	CheckOutOverview checkOutOverview;
	@BeforeSuite
	public void setUpAutomation() {
		loadConfigFile();
		setUp();
		initReport();
	}
  @Test
  public void login() {
	  loginPage =new LoginPage(driver);
	  loginPage.loginToApplication(getProperty("username"), getProperty("password"));
  }
  @AfterSuite
	public void shutDown() {
		tearDown();
		reports.flush();
	}
  
  
}
