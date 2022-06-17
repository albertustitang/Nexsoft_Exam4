package com.nexsoft.exam4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	protected WebDriver driver;
	

	@FindBy(xpath = "//img[@src='../images/logo-topbar.gif']")
	private WebElement btn_dashboard;

	@FindBy(xpath = "//div[@id='WelcomeContent']" )
	private WebElement firstName;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	


	public String getFirstName() {
		return firstName.getText();
	}
	public String getSignIn() {
		return btn_dashboard.getText();
	}

}
