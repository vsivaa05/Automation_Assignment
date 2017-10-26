package com.java.straitstimes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;

	/**
	 * Locate Login Tab.
	 * 
	 * @param driver
	 * @return the Login element
	 */
	public static WebElement login(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("//*[@id='navbar']/div/div[2]/nav/div[2]/div/ul/li[1]/a"));
		return element;
	}

	/**
	 * Locate Article Tab.
	 * @param driver
	 * @return
	 */
	public static WebElement article(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("//*[@id='block-system-main']/div/div/div/div/div[2]/div/div/div/div[5]/div/div/div/div/a"));
		return element;
	}
}
