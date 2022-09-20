package org.tyss.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(xpath = "//body/div[@id='container']/descendant::div[@data-id='ROHG9R5RWDHK9V2T']/div/a[@title]")
	private WebElement firstProduct;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnFirstProduct() {
		firstProduct.click();
	}
	
	public String textOfProduct() {
		String actualText = firstProduct.getText();
		
		return actualText;
	}
	
	public String titleOfProduct() {
		String actualText = firstProduct.getAttribute("title");
		
		return actualText;
	}
}
