package org.tyss.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchBox;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void enterText() {
		searchBox.sendKeys("winter heater");
		searchBox.sendKeys(Keys.ENTER);
	}
	

}
