package com.webappsecurity.zero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="user_login")
	private WebElement userName;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(name="submit")
	private WebElement signIn;
	
	@FindBy(css="#login_form > div.alert.alert-error")
	private WebElement errorMsgBox;
	
	
	public Login(WebDriver driver ) {
		PageFactory.initElements(driver, this);
		
		
	}
	public void applicationLogin(String loginName,String loginPassword) {
		userName.sendKeys(loginName);
		password.sendKeys(loginPassword);
		signIn.click();
	}
	
	public String getErrorMsgText() {
		String errorMsg = errorMsgBox.getText();
		return errorMsg;
	}

}

