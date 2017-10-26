package com.java.straitstimes.mobile.app.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Main {

	AppiumDriver<MobileElement> driver = null;

	@BeforeMethod
	public void init() {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "sivaa");
		caps.setCapability("udid", "4e03979e");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "com.buuuk.st");
		caps.setCapability("appActivity", "com.sph.straitstimes.views.activities.SplashActivity");

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testMobileApp() {
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@content-desc = 'Navigate up']")).click();
		
		driver.findElement(By.id("com.buuuk.st:id/tv_login")).click();
		
		driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_username")).sendKeys("v.sivaa05@gmail.com");
		
		driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_password")).sendKeys("Sgpass123");
		
		driver.findElement(By.id("com.buuuk.st:id/btn_ldap_login_continue")).click();
		
		driver.findElement(By.xpath("//*[@content-desc = 'Navigate up']")).click();
		
		if (driver.getPageSource().contains("v.sivaa05@gmail.com"))
		{
			System.out.println("You have logged in successfully");
		}
		else
		{
			System.out.println("Invalid Login");
		}
		
		driver.findElement(By.id("com.buuuk.st:id/iv_home")).click();
		
		driver.findElement(By.linkText("LATEST")).click();
		
		driver.findElement(By.id("com.buuuk.st:id/article_title")).click();
		
		if (driver.getPageSource().contains(".jpg")) {
			System.out.println("This screen has image");
		} else {
			System.out.println("This screen does not have image");
		}
		
	}

}
