package org.tyss.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.tyss.pageobject.AddToCartPage;
import org.tyss.pageobject.CartPage;
import org.tyss.pageobject.HomePage;
import org.tyss.pageobject.ProductPage;
import org.tyss.pageobject.loginPageTest;

public class ReuseableClass {
	public CommonDataUtility prop;

	public JavaClassUtility javaUtil;
	public CommonDriverMethodUtility webUtility;
	public String url;
	public String usn;
	public String psd;
	public String browser;
	public String timeouts;
	public WebDriver driver;
	public long longTimeout;
	public loginPageTest lgpg;
	public HomePage hppg;
	public ProductPage productPage;
	public AddToCartPage addCart;
	public CartPage cartPg;

	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("before suite method is executing");
	}


	@BeforeTest
	public void beforetestMethod() {
		System.out.println("before test is executing");
	}
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("before class method");

		//utility object creation
		prop=new CommonDataUtility();
		javaUtil=new JavaClassUtility();
		webUtility=new CommonDriverMethodUtility();




	}
	@BeforeMethod
	public void beforeMethod() {
		prop.loadPropertyFile(IConstantUtility.FLIPKARTPROPERTYFILEPATH);

		url = prop.getPropertyData("url");
		usn = prop.getPropertyData("username");
		psd = prop.getPropertyData("password");

		browser = prop.getPropertyData("browser");
		timeouts = prop.getPropertyData("timeout");

		driver=webUtility.browserSelect(browser);

		//pom class object creation
		lgpg=new loginPageTest(driver);
		hppg=new HomePage(driver);
		productPage=new ProductPage(driver);
		addCart=new AddToCartPage(driver);
		cartPg=new CartPage(driver);



		webUtility.browserMaximize();
		longTimeout = javaUtil.stringToIntConvertUsingParse(timeouts);
		webUtility.implicitWaitMethodCall(longTimeout);
		webUtility.getUrlMethod(url);

	}
	@AfterMethod
	public void afterMethod() {

		webUtility.browserQuit();
	}
	@AfterClass
	public void afterClassMethod() {
		System.out.println("after class method");
	}

	@AfterTest
	public void afterTestMethod() {
		System.out.println("after test is executing");
	}

	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("after suite method is executing");
	}

}
