package saucelab.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;

public class TestBase {
	public static WebDriver driver;
	public Properties properties;
	public static Logger logger = Logger.getLogger(TestBase.class);
	public static ExtentReports reports=null;
	public static ExtentTest test = null;
	public static ExtentSparkReporter spark =null;
	String configPropPath=System.getProperty("user.dir")+"/src/main/resources/config.properties";

	@SuppressWarnings("deprecation")
	public void setUp() {
		try {
			logger.info("Initializing..Setup");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(getProperty("url"));
		} catch (Exception e) {
			
		}
	}
	public void loadConfigFile() {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(configPropPath);
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	public void tearDown() {
		driver.quit();
	}
	public void initReport() {
		reports = new ExtentReports();
		String reportPath= System.getProperty("user.dir")+"/target/ExtentReport.html";
		spark = new ExtentSparkReporter(reportPath);
		reports.attachReporter(spark);
	}
	
}
