package io.cucumber.patricia.services;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Settings {

    public static WebDriver browser;

    // public static Actions actions = new Actions(browser);

    public static void openBrowser(String url) {
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            browser = new ChromeDriver();
        }
        
        browser.get(url);
        browser.manage().window().maximize();

    }

    public static void closeBrowser() {
        browser.quit();
        browser = null;
    }

    public static WebElement cssSelector(String selector) {
		return browser.findElement(By.cssSelector(selector));
	}
	
	public static List<WebElement> cssSelectors(String selector) {
		return browser.findElements(By.cssSelector(selector));
	}

	public static WebElement id(String selector) {
		return browser.findElement(By.id(selector));
	}
    
}
