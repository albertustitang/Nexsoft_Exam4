package com.nexsoft.exam4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	protected WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Enter the Store']")
	private WebElement btnHomePage;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage clickToHomePage() {
		
		btnHomePage.click();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		return homePage;
	}

}
