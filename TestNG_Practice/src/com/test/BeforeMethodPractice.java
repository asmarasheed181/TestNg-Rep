package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodPractice {
	WebDriver driver;
	
	@BeforeMethod
	
	public void Initialization()
	{
		driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	
	public void Myntra() throws InterruptedException
	{
		WebElement Men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions a= new Actions(driver);
		a.moveToElement(Men).build().perform();
		Thread.sleep(2000);
		
	}
	@Test(priority=3)
	public void Myntrawomen() throws InterruptedException
	{
		WebElement Men = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
		Actions a= new Actions(driver);
		a.moveToElement(Men).build().perform();
		Thread.sleep(2000);
		
		
	}
	@Test(priority=1)
	public void MyntraSearch() throws InterruptedException
	{
		WebElement Men = driver.findElement(By.xpath("//a[text()='Beauty']"));
		Actions a= new Actions(driver);
		a.moveToElement(Men).build().perform();	
		Thread.sleep(2000);
	}
	@AfterMethod
	public void Cleanup()
	{
		driver.quit();
	}

}
