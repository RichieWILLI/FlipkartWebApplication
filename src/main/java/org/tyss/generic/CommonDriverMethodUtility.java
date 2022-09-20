package org.tyss.generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is used to perform action related to webelement driver i.e,for maximizing the browser,implicitly wait,choose the browser,actions class,get url,close browser etc
 * @author Richard William
 *
 */


public class CommonDriverMethodUtility {
	private WebDriver driver;
	private Actions act;
	WebDriverWait wait;
	
	/**
	 * this is method which calls for choosing the browser i.e, which browser to select like chrome, firefox, internet explorer
	 * @param browser
	 * @return
	 */
	
	public WebDriver browserSelect(String browser) {
		
		
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("the browser name may be incorrect");
		}
		return driver;
	}
	
	/**\
	 * This is a method to class the actions class
	 */

	public void actionClassCall() {
	 act = new Actions(driver);
	}
	/**
	 * This method is used to perform the mousehover actions
	 * @param element
	 */
	
	public void mousehoverAction(WebElement element) {
		act.moveToElement(element).perform();
	}
	
	/**
	 * This is the method which is used to mazimize the browser
	 */
	
	public void browserMaximize() {
		
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to  Snychronize the browser and selenium implicity
	 * @param Timeout
	 */
	
	public void implicitWaitMethodCall(long Timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
	}
	
	/**
	 * This is a method which is used to call the explicit wait method
	 * @param Timeout
	 * @return 
	 */
	
	public WebDriverWait explicitWaitMethodCall(long Timeout) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(Timeout));
	return wait;
	}
	
	
	
	
	
	/**
	 * This a method is used to get url
	 * @param url
	 */
	public void getUrlMethod(String url) {
		driver.get(url);
	}
	
	/**
	 * This is the method used to close the browser
	 */
	public void browserClose() {
		driver.close();
	}
	
	/**
	 * this method is used for closing all the parent browser as well as child browser
	 */
	
	public void browserQuit() {
		driver.quit();
	}
	
	/**
	 * This method is used to call the custom wait whenever the driver unable to click on web element..this method will make the selenium to wait for specified timeout(polling time)
	 * @param element
	 * @param timeout
	 */
	
	
	public void customWait(WebElement element, long timeout) {
		
		int count=0;
		while(count<=timeout) {
		try {
			element.click();
		break;
		}
		catch(Exception e) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			count++;
			}
		}
		
		
	}
	
	/**
	 * This method is used to accept the alert notification
	 */
	
	public void alertPopUpAccept() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to dismiss the alert pop up
	 */
	
	public void alertPopUpDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method is used to write data into alert pop up
	 * @param key
	 */
	public void alertPopUpSendkeys(String key) {
		driver.switchTo().alert().sendKeys(key);
	}
	
	
	/**
	 * This method will help to get the text from the alert popUp
	 */
	public void alertPopUpGetText() {
		driver.switchTo().alert().getText();
	}
	
	/**
	 * this method is used to take screenshot
	 */
public void takeScreenShot() {
		
	
	TakesScreenshot screenShot=(TakesScreenshot) driver;
	File src = screenShot.getScreenshotAs(OutputType.FILE);
	File fil=new File("./screenshot/ss.png");
	try {
		FileUtils.copyFile(src, fil);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
	}

/**
 * this method is used to call the explicit wait by visibility of element locator i.e, by.xpath("element xapth");
 * @param longTimeouts
 * @param elementXpath
 */

public void explicitlyWaitVisibilityOfElementLocator(long longTimeouts,String elementXpath) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(longTimeouts));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
}



public void explicitlyWaitForUrl(String url) {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.urlToBe(url));
}

public void explicitlyWaitForTitle(String title) {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.titleContains(title));
}

	/**
	 * This method is to get the window handles
	 * @return
	 */
public Set<String> getWindowHandles() {
	Set<String> allwhs = driver.getWindowHandles();
	return allwhs;
}

public String getParentWindowHandle() {
	String whs = driver.getWindowHandle();
	return whs;
}

/**
 * this method is to navigate window back/click back button
 */
public void navigateBack() {
	driver.navigate().back();
}




/**
 * This method is used to switch to child window
 * @param handle
 */
public void switchToWindow(String handle) {
	driver.switchTo().window(handle);
}

	
}
