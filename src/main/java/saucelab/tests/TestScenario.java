package saucelab.tests;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.utility.RandomString;
import saucelab.pages.TwitteerLoginPage;
import saucelab.pages.TwitterHomePage;
import java.net.*;

public class TestScenario extends PreRequisite {
	TwitteerLoginPage loginPage;
	TwitterHomePage homePage;
	public AndroidDriver <MobileElement> adriver;	
//	
  @Test(priority = 0)
  public void loginToApplication() {
	  loginPage = new TwitteerLoginPage(driver);
	loginPage.loginToX(getProperty("username"), getProperty("password"));
	homePage = new TwitterHomePage(driver);
	assertTrue(homePage.isHomeLogoDisplayed());
  }
  @Test(dataProvider = "postData", priority = 1)
public void createXPost(String post) {
	homePage.createPost(post);
}
//  @Test(dataProvider = "postData",priority = 2)
//public void searchForPostAndTakeSSPost(String post1) {
//	try {
//		homePage.searchPost(post1);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
//}
	@Test(priority = 3, alwaysRun = false)
	public void startAppimAndDriver() throws IOException, InterruptedException,NullPointerException {
		//UiAutomator2Options opts = new UiAutomator2Options();
		 DesiredCapabilities capabilities  = new DesiredCapabilities();
		//opts.setDeviceName("b1993e940602");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "wgfq55knai654x6t");
		//opts.setApp("");
		//opts.setPlatformName("Android");
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		//opts.setPlatformVersion("11");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.twitter.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.twitter.android.StartActivity");
		//opts.setAppPackage("com.twitter.android");
		//opts.setAppActivity("com.twitter.android.StartActivity");
	     adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
	     adriver.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Search X\"]/android.widget.TextView")).click();
	     Thread.sleep(4000);
	     adriver.findElement(MobileBy.xpath("//android.widget.EditText[@content-desc=\"Search button\"]")).sendKeys("dandhareparag1");
	     Thread.sleep(4000);
	     adriver.findElement(MobileBy.xpath("//*[@text=\"Go to @dandhareparag1\"]")).click();
	     Thread.sleep(4000);
	     String post1 = getProperty("post4");
	     Thread.sleep(4000);
	     String xpath1 ="//android.view.View[@text='"+post1+"']";
	     adriver.findElement(MobileBy.xpath(xpath1)).click();
	     Thread.sleep(4000);
	     getshot(adriver);
	     Thread.sleep(4000);
	     String post2 = getProperty("post5");
	     Thread.sleep(4000);
	     adriver.findElement(MobileBy.xpath("//android.view.View[@text='"+post2+"']")).click();	     
	     Thread.sleep(4000);
	     getshot(adriver);
	     Thread.sleep(4000);
	     String post3 = getProperty("post6");
	     adriver.findElement(MobileBy.xpath("//android.view.View[@text='"+post3+"']")).click();
	     Thread.sleep(2000);
	     getshot(adriver);
	     Thread.sleep(2000);
	     adriver.quit();
//	     Thread.sleep(1000);
	    //UiAutomator2Options iopts = new UiAutomator2Options();
	    DesiredCapabilities capabilities1  = new DesiredCapabilities();
	    capabilities1.setCapability(MobileCapabilityType.DEVICE_NAME, "wgfq55knai654x6t");
		 capabilities1.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 capabilities1.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		capabilities1.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities1.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.instagram.android");
        capabilities1.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.instagram.mainactivity.LauncherActivity");
       // capabilities1.setCapability(MobileCapabilityType.NO_RESET, true);
	     adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities1);
	     Thread.sleep(8000);
	    //adriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Log In\"]")).click();
	     KeyEvent volumeDown = new KeyEvent(AndroidKey.BACK);
	     adriver.pressKey(volumeDown);
	     Thread.sleep(2000);
   adriver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Username, email address or mobile number']")).click();
Thread.sleep(1000);
adriver.pressKey(volumeDown);
adriver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Username, email address or mobile number']")).click();
	    adriver.findElement(MobileBy.xpath("//android.view.View[@content-desc='Username, email address or mobile number']")).click();
		 adriver.findElement(MobileBy.xpath("//android.widget.EditText")).sendKeys("testautotestauto7@gmail.com");
//		 //password
		 adriver.findElement(MobileBy.xpath("//android.widget.EditText[@password=\"true\"]")).sendKeys("jayesh@123");
//		 //loginbtn 
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Log In\"]")).click();
	     Thread.sleep(5000);
//		 notnow
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Not Now\"]")).click();
		 Thread.sleep(5000);
		//android.widget.LinearLayout[@content-desc="Choose a Credential"]/android.widget.LinearLayout/android.widget.Button
		 //post
		 
		 adriver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Camera\"]/android.widget.ImageView")).click();
		 //allow
		 Thread.sleep(5000);
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@text = \"ALLOW\"]")).click();
		 Thread.sleep(5000);
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@text = \"WHILE USING THE APP\"]")).click();
		 Thread.sleep(1000);
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@text = \"WHILE USING THE APP\"]")).click();
		 //select multiple

		 Thread.sleep(5000);
		 adriver.findElement(MobileBy.xpath("//*[@text = \"SELECT MULTIPLE\"]")).click();
		 adriver.findElement(MobileBy.xpath("//android.widget.CheckBox[2]")).click();
		 adriver.findElement(MobileBy.xpath("//android.widget.CheckBox[3]")).click();
		 //adriver.findElement(MobileBy.xpath("//android.widget.CheckBox[4]")).click();
		// adriver.findElement(MobileBy.xpath("//android.widget.CheckBox[5]")).click();
		 adriver.findElement(MobileBy.xpath("//*[@text =\"Next\"]")).click();
		 Thread.sleep(5000);
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
		 Thread.sleep(5000);
		 adriver.findElement(MobileBy.xpath("//android.widget.EditText[@text=\"Write a caption…\"]")).sendKeys("Super happy to participate in #tristhaautothon organized by tristha.");
		 adriver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Share\"]")).click();
	}

	public void getshot(AndroidDriver<MobileElement> adriver) {
		File screenshotFile = adriver.getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(3);
		String deviceStoragePath = "/storage/emulated/0/DCIM/screenshots/screenshot"+random+".png";
		  try {
	            // Move the screenshot file to the specified location on the device's storage
	           adriver.pushFile(deviceStoragePath, screenshotFile);
	            System.out.println("Screenshot saved to: " + deviceStoragePath);
	            adriver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
//	public static void main(String[] args) throws InterruptedException {
//		TestBase  tb = new TestBase();
//		tb.loadConfigFile();
//		String post1 =  tb.getProperty("post4");
//	     String xpath1 ="//android.view.View[@text='"+post1+"']";
//	     System.out.println("xpath1 "+xpath1);
//	}
}
