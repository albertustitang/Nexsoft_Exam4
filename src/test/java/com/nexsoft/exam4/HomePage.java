package com.nexsoft.exam4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;


	
	@FindBy(xpath = "//*[@id=\"MenuContent\"]/a[2]")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement btnRegister;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}


	public SignInPage clickSignIn() {
		signIn.click();
		
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}
	
	public RegisterPage clickRegisterPage() {
		
		btnRegister.click();
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		
		return registerPage;
	}
}