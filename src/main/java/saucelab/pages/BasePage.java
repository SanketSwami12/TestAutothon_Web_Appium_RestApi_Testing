package saucelab.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.utility.Screenshot;

import saucelab.tests.TestBase;



public class BasePage extends TestBase {
public WebDriver driver;
public WebDriverWait wait;

public void hilite(WebDriver webDriver, WebElement element) throws InterruptedException {		

	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('style','background: #FFFF00 !important; border: 2px solid #FFA000 !important; color: #000000 !important;');",
			element);
}

public BasePage(WebDriver driver) {
	this.driver=driver;
	wait = new WebDriverWait(driver, 20);
}

public void waitForElementToBeVisible(WebElement element) {
	try {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(element));
		hilite(driver, element);
	} catch (Exception e) {
		System.out.println(e.toString());
	}
}

public void click(WebElement element, String stepName) {
    try {
        waitForElementToBeVisible(element);
       // String screenshotPath = Screenshot.getScreenshot(stepName);
        //test.log(Status.INFO, stepName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        element.click();
    } catch (Exception e) {

        e.printStackTrace();
    }
}
public void jsClick(WebElement element) {
	  try {
	Actions actions = new Actions(this.driver);
	waitForElementToBeVisible(element);
	actions.moveToElement(element).perform();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", element);
	System.out.println("SUCCESS: Successfully clicked the element ");
} catch (Exception e) {
System.out.println( "FAIL: Exception occurred while finding element : Unable to click element"
		+ e.toString());
}
	
}

public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText ) {
    try {
        waitForElementToBeVisible(dropdownElement);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    } catch (Exception e) {
       
        e.printStackTrace();
    }
}

public void selectDropdownByValue(WebElement dropdownElement, String value) {
    try {
        waitForElementToBeVisible(dropdownElement);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    } catch (Exception e) {
    
        e.printStackTrace();
    }
}

public void selectDropdownByIndex(WebElement dropdownElement, int index) {
    try {
        waitForElementToBeVisible(dropdownElement);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    } catch (Exception e) {
       
        e.printStackTrace();
    }
}

public void enterText(WebElement element, String text,String stepName ) {
    try {
        waitForElementToBeVisible(element);

        element.clear();
        element.sendKeys(text);
        System.out.println("Text Entered in "+ element.toString()+ " element with test data "+text);
     //   String screenshotPath = Screenshot.getScreenshot(stepName);
      //  test.log(Status.INFO, stepName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    } catch (Exception e) {
        
        e.printStackTrace();
    }
}
public String getTitleOfCurrentPage() {
	String title = null;
	try {
		title =driver.getTitle();
}
	catch (Exception e) {
		e.printStackTrace();
	}
	return title;
}

public String getTextOfAnElement(WebElement element) {
	String text = "";
	try {
		waitForElementToBeVisible(element);
		text = element.getText();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return text;
}
public void switchToFrame(WebElement frameElement) {
	try {
		driver.switchTo().frame(frameElement);
	} catch (Exception e) {
		System.out.println("FAIL: exception description : "+ e.toString());
	}
}
public boolean verifyText(String expResult, String actResult) {
	boolean result = false;
	try {
		if(expResult.equalsIgnoreCase(actResult)) {
			result =true;
			System.out.println("SUCCESS: Expected And Actual are Matching Expected: "+expResult+"|Actual: "+actResult);
		}
	else {

		System.out.println("SOFTFAIL: Exception occurred while getting element : Expected And Actual not Matching: "+expResult+"|Actual: "+actResult);
	}
	}
	catch (Exception e) {
	System.out.println("SOFTFAIL: Exception occurred while getting element : Expected And Actual not Matching: "+expResult+"|Actual: "+actResult
				+ e.toString());
	}
	return result;
}

public void handlingWindows() {
    try {
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        driver.switchTo().window(parentWindowHandle);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void executeJavaScript(String script) {
    try {
        ((JavascriptExecutor) driver).executeScript(script);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void explicitWaitForCondition(ExpectedCondition<Boolean> condition) {
    try {
        WebDriverWait customWait = new WebDriverWait(driver, 10);
        customWait.until(condition);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void switchToWindowByHandle(String windowHandle) {
    try {
        driver.switchTo().window(windowHandle);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void switchToWindowByTitle(String windowTitle) {
    try {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void closeCurrentTab() {
    try {
        driver.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void scrollToElement(WebElement element) {
    try {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void waitForPageToLoad() {
    try {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void performDragAndDrop(WebElement source, WebElement target) {
    try {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void performRightClick(WebElement element) {
    try {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void performMouseHover(WebElement element) {
    try {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void waitForElementToBeClickable(WebElement element) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void selectFromDropdown(WebElement dropdownElement, String value) {

try {
waitForElementToBeVisible(dropdownElement);
Select dropdown = new Select(dropdownElement);
dropdown.selectByValue(value);
} catch (Exception e) {
e.printStackTrace();
}
}
public void waitForElementToBeClickableAndClick(WebElement element) {
    try {
        waitForElementToBeClickable(element);
        element.click();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

