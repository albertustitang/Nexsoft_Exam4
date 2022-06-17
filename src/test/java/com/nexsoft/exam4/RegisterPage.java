package com.nexsoft.exam4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	protected WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userID;
	@FindBy(css = "input[name='password']")
	private WebElement newPasswd;
	@FindBy(css = "input[name='repeatedPassword']")
	private WebElement repPasswd;
	@FindBy(css = "input[name='account.firstName']")
	private WebElement firstName;
	@FindBy(css = "input[name='account.lastName']")
	private WebElement lastName;
	@FindBy(css = "input[name='account.email']")
	private WebElement email;
	@FindBy(css = "input[name='account.phone']")
	private WebElement phone;
	@FindBy(css = "input[name='account.address1']")
	private WebElement address1;
	@FindBy(css = "input[name='account.address2']")
	private WebElement address2;
	@FindBy(css = "input[name='account.city']")
	private WebElement city;
	@FindBy(css = "input[name='account.state']")
	private WebElement state;
	@FindBy(css = "input[name='account.zip']")
	private WebElement zipCode;
	@FindBy(css = "input[name='account.country']")
	private WebElement country;
	@FindBy(css = "input[value='Save Account Information']")
	private WebElement registerBtn;

	public RegisterPage() {
		
		this.driver = driver;
	}

	public HomePage registerUser(String user_userID, String user_password, String user_repeatPsw,
			String user_firstName, String user_lastName, String user_email, String user_phone, String user_address1,
			String user_address2, String user_city, String user_state, String user_zipCode, String user_country) {

		userID.sendKeys(user_userID);
		
		newPasswd.sendKeys(user_password);
		
		repPasswd.sendKeys(user_repeatPsw);

		firstName.sendKeys(user_firstName);
		
		lastName.sendKeys(user_lastName);
		
		email.sendKeys(user_email);
		
		phone.sendKeys(user_phone);
		
		address1.sendKeys(user_address1);
		
		address2.sendKeys(user_address2);
		
		city.sendKeys(user_city);
		
		state.sendKeys(user_state);
		
		zipCode.sendKeys(user_zipCode);
		
		country.sendKeys(user_country);
		
		registerBtn.click();

		return PageFactory.initElements(driver, HomePage.class);
	}

}
