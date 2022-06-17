package com.nexsoft.exam4;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nexsoft.exam4.HomePage;

public class TestLoginFunctionality {
	protected WebDriver driver;
	private JavascriptExecutor jse;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String screenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\Bootcamp\\com.nexsoft.exam4\\src\\test\\resources" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));

		HomePage home = PageFactory.initElements(driver, HomePage.class);

	}

	@Test(priority = 1)
	public void testFrontPage() {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);

		HomePage home = landingPage.clickToHomePage();

		SignInPage signInPage = home.clickSignIn();

		RegisterPage registerPage = home.clickRegisterPage();

	}

//		
	@Test(priority = 2)
	public void testLogin_with_Valid_User_and_Password() {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickToHomePage();

		SignInPage signInPage = home.clickSignIn();

		Dashboard dashboard = home.clickSignIn().loginValid("albert", "12345");

		delay(300);

		jse.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);

		Assert.assertEquals(dashboard.getFirstName(), "Welcome albert!");
	}

	@Test(priority = 3)
	public void testValidRegister() {

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickToHomePage();

		SignInPage signInPage = home.clickSignIn();

		home.clickRegisterPage().registerUser("titan", "12344", "12344", "tan", "tan", "titann@gmail.com",
				"081225443221", "Jl. Scientia Boulevard", "Ruko Newton no.16", "Tangerang", "Banten", "531230",
				"Indonesia");

		delay(300);

		jse.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);

	}

}
