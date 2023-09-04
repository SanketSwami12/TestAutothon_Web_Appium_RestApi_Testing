package com.utility;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import saucelab.tests.TestBase;

public class Screenshot extends TestBase{

	public static String getScreenshot(String name) {
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String path =System.getProperty("user.dir")+"/screenshot/"+name+".jpg";
			File dest =new File(path);
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				System.out.println("Fail: failed to copy file"+ e.toString());
			}
		return path;
	}
}
