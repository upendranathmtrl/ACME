package com.testleaf.ACME_System;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void LoginMethod() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementByName("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementByName("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		WebElement vendorEle = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		Actions builder = new Actions(driver);
		builder.moveToElement(vendorEle).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		WebElement findElement = driver.findElement(By.xpath("//td[text()='France']"));
		String text = findElement.getText();
		System.out.println("The country name of the vendor is" +text);
		
}
}
