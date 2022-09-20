package org.tyss.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	public String textOfProduct;
	
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement cartedProduct;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String textOfCartedProduct(String actualdata) {
		 String expected = cartedProduct.getText();
		System.out.println(expected);
		Assert.assertEquals(actualdata, expected);
		System.out.println("yes the product is present in the cart");
		return expected;
		
	}
	public void checkForProduct(String actualData) {
		textOfProduct.contains(actualData);
		System.out.println("yes the product is present in cart ");
	}
	

}
