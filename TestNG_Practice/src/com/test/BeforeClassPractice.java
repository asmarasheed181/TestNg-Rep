package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeClassPractice {
	WebDriver driver;
	
	@BeforeClass
	public void Initialization()
	{
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void Flipkartflights() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mobiles");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}
	@Test (priority=2)
	public void FlipkartFurniture() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Watches");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@AfterClass
	public void Cleanup()
	{
		driver.quit();
	}
		
	}
	


