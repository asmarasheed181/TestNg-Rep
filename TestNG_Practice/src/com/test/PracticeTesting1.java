package com.test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTesting1 {
	WebDriver driver;
	@BeforeClass
	public void Initialization() throws InterruptedException
	{
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
	}
	@Test
	public void Test1() throws InterruptedException 
	{
	  
		
		WebElement orders= driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions a = new Actions(driver);
		a.moveToElement(orders).perform();
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='nav-title']|//a[@class='nav-link nav-item']"));
		System.out.println(li.size());
		for(int i=0; i<li.size();i++)
		{
			//li.get(i).click();
			System.out.println(li.get(i).getText());
		}
	}
	@Test
	public void Test2() throws InterruptedException
	{
       
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("Makeup Products");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@type='submit'] )[1]")).click();
		
		Thread.sleep(2000);
		WebElement orders = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Thread.sleep(2000);
		
		Actions a= new Actions(driver);
		
		a.moveToElement(orders).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Your Orders']")).click();
		
	}
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}

}
