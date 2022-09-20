package org.tyss.pageobject;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.generic.CommonDriverMethodUtility;

public class AddToCartPage {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[.='Cart']")
	private WebElement cartBtn;
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickAddToCart() {
		
		addToCartBtn.click();
	}
	
public void clickAddToCart(CommonDriverMethodUtility webUtility) {
		
		//addToCartBtn.click();
	String pwh = webUtility.getParentWindowHandle();
	Set<String> allwh = webUtility.getWindowHandles();	

	for (String all : allwh) {
		driver.switchTo().window(all);

		if(all.equals(pwh)) {

		}
		else {
			addToCartBtn.click();

		}

	}

	}
	
	
	
	
	public void clickCartBtn(CommonDriverMethodUtility webUtility,String title) {
		
		
		String currentUrl = driver.getCurrentUrl();
		webUtility.explicitlyWaitForUrl(currentUrl);
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span")));
		
		
		
		webUtility.navigateBack();
		
		webUtility.explicitlyWaitForTitle(title);
		cartBtn.click();	
	}
	

}
