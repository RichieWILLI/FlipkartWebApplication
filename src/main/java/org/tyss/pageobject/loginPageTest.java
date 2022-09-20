package org.tyss.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageTest {
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closeButton;
	
	
	@FindBy(xpath ="//div/form[@autocomplete='on']/div/input[@type='text']")
	private WebElement userNameTextBox;
	
	@FindBy(xpath ="//div/form[@autocomplete='on']/div/input[@type='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//span[@class='_36KMOx']/span[.='Login']")
	private WebElement loginBtn;
	
	
	public loginPageTest(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickClosebutton()
	{
		closeButton.click();
	}
	
	public void loginCredentials(String username,String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginBtn.click();
		
		
	}
}
