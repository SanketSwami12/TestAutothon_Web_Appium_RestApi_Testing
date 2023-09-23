package saucelab.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.utility.CustomRetryAnalyzer;

public class PreRequisite extends TestBase {
	@BeforeSuite
	public void setUpAutomation() {
		loadConfigFile();
		setUp();
		initReport();
	}
	  @AfterSuite
		public void shutDown() {
			tearDown();
			reports.flush();
		}
	@DataProvider(name = "postData")
    public Object[][] postData() {
        return new Object[][] {
            { getProperty("post4") },
            { getProperty("post5") },
            { getProperty("post6")}
        };
}
}