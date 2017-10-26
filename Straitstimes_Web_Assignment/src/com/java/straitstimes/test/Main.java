package com.java.straitstimes.test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.straitstimes.pages.HomePage;
import com.java.straitstimes.pages.LoginPage;
import com.java.straitstimes.util.Util;

public class Main {

	private WebDriver driver;

	@Test
	public void testWeb() {

		HomePage.login(driver).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LoginPage.locateLoginId(driver).sendKeys(Util.USER_NAME);

		LoginPage.locatePassword(driver).sendKeys(Util.PASSWORD);

		LoginPage.locateSignIn(driver).click();

		// Option 1 to verify the success login
		assertTrue(driver.getPageSource().contains(Util.USER_NAME));
																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		// Option 2 to verify the success login
		if (driver.getPageSource().contains(Util.USER_NAME)) {
			System.out.println("You have logged in successfully");
		} else {
			System.out.println("Login Failed");
		}
		
		// Verify that the page has any image
		if (driver.getPageSource().contains(".jpg")) {
			System.out.println("This page has picture");
		} else {
			System.out.println("This page does not have picture");
		}

		HomePage.article(driver).click();
		
		String homePageTitle = driver.findElement(By.xpath(".//*[@id='block-system-main']/div/div[1]/div/header/h1")).getText();
		String title = driver.getTitle();

		if (title.equalsIgnoreCase(homePageTitle)) {
			System.out.println("Navigated to main Article");
		} else {
			System.out.println("Not Navigated to main Article");
		}
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", Util.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Util.BASE_URL);

	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

}
