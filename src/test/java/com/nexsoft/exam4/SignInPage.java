package com.nexsoft.exam4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SignInPage {

	protected WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='signon']")
	private WebElement btnSignIn;
	
	
	

	public SignInPage(WebDriver driver) {

		this.driver = driver;

	}

	public Dashboard loginValid(String user_name, String user_password) {
		username.clear();
		username.sendKeys(user_name);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		return dashboard;
	}
	
}