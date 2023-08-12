package com.narinderpal.singh.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By loginbtn	= By.xpath("//button[@id='loginBtn']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginToAccount(String Username, String Password) {
		driver.findElement(username).sendKeys(Username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(loginbtn).click();	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void acceptcookies() {
		driver.manage().getCookies().forEach(n->driver.manage().addCookie(n));;		
	}

}
