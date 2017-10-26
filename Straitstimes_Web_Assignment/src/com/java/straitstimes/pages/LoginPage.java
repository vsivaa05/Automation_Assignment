package com.java.straitstimes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebElement element = null;

	public static WebElement locateLoginId(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id='j_username']"));

		return element;
	}
	
	
	public static WebElement locatePassword(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='j_password']"));

		return element;
	}
	
	public static WebElement locateSignIn(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='loginForm']/button"));

		return element;
	}


}
