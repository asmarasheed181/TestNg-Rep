package com.test;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTesting {
	WebDriver driver;
	@BeforeMethod
	public void Initialization() throws InterruptedException
	{
        driver = new ChromeDriver();
		
		driver.get("https://www.Amazon.in");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
	}
	@Test
	public void Test1() throws InterruptedException
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
	
	@Test
	public void Test2() throws InterruptedException 
	{
		
		WebElement dd = driver.findElement(By.name("url"));
		
		 Select sc = new Select(dd);
		List<WebElement> li = sc.getOptions();
		
		System.out.println(li.size());
		
		for(int i=0; i<li.size(); i++)
		{
			li.get(i).click();
			System.out.println(li.get(i).getText());
		}
		
		for(int i=li.size()-1; i>=0; i--)
		{
			li.get(i).click();
			System.out.println(li.get(i).getText());
		}
		

	}
	@AfterMethod
	public void Cleanup()
	{
		driver.quit();
	}

}
