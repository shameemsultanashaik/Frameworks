package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement conTextBox;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement username;
	
	@FindBy(id="logout_link")
	private WebElement logout;
	
	@FindBy(id="signin_button")
	private WebElement signin;
	
	
	public TransferFundsConfirmation(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getconText() {
		
		String ConText= conTextBox.getText();
		return ConText;
		
		
	}
	
	public void logOutFromApp() {
		username.click();
		logout.clear();
		signin.clear();
		
	}
	

}
