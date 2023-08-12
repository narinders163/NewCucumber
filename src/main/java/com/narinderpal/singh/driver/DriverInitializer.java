package com.narinderpal.singh.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {
	static WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browsername) {
		if(browsername.equals("chrome")) {
			driver = new ChromeDriver();
			tlDriver.set(driver);
		}
		else if(browsername.equals("edge")) {
			driver = new EdgeDriver();
			tlDriver.set(driver);
		}
		else {
			driver = new FirefoxDriver();
			tlDriver.set(driver);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}
	

}
