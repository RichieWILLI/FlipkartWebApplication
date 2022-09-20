package org.tyss.flipkart_webapplication_assingment;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.generic.ReuseableClass;
import org.tyss.pageobject.AddToCartPage;
import org.tyss.pageobject.CartPage;
import org.tyss.pageobject.HomePage;
import org.tyss.pageobject.ProductPage;
import org.tyss.pageobject.loginPageTest;

public class AddToCart extends ReuseableClass {

	@Test
	public void addToCart()   {


		lgpg.clickClosebutton();							
		hppg.enterText();									
		String actualdata = productPage.titleOfProduct();
		System.out.println(actualdata);			
		productPage.clickOnFirstProduct();	
		addCart.clickAddToCart(webUtility);
		addCart.clickCartBtn(webUtility,actualdata);
		cartPg.textOfCartedProduct(actualdata);



	}

}
