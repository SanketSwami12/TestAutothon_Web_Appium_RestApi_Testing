package saucelab.tests;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.utility.RandomString;

public class Appium {
	
public static void main(String[] args) throws Exception{	
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
   AndroidDriver <MobileElement>adriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
    adriver.findElement(MobileBy.xpath("//android.widget.RelativeLayout[@content-desc=\"Search X\"]/android.widget.TextView")).click();
    adriver.findElement(MobileBy.xpath("//android.widget.EditText[@content-desc=\"Search button\"]")).sendKeys("dandhareparag1");
    adriver.findElement(MobileBy.xpath("//*[@text=\"Go to @dandhareparag1\"]")).click();
    Thread.sleep(2000);
    //String post1 = getProperty("post4");
    adriver.findElement(MobileBy.xpath("//android.view.View[@text=\"jspop12121Post11\"]")).click();
    Thread.sleep(2000);
    getshot(adriver);
    Thread.sleep(2000);
    adriver.findElement(MobileBy.xpath("//android.view.View[@text=\"jspop12121Post22\"]")).click();	     
    Thread.sleep(2000);
    getshot(adriver);
    Thread.sleep(2000);
    adriver.findElement(MobileBy.xpath("//android.view.View[@text=\"jspop12121Post33\"]")).click();
    Thread.sleep(2000);
    getshot(adriver);
    Thread.sleep(2000);
    adriver.quit();
}
public static void getshot(AndroidDriver<MobileElement> adriver) {
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
}
