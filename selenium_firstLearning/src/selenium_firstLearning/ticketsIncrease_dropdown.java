package selenium_firstLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ticketsIncrease_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/dropdownsPractise";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		
		driver.findElement(By.className("paxinfo")).click();
		Thread.sleep(2000);
		for (int i=0;i<4;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		String tickets=driver.findElement(By.className("paxinfo")).getText();
		System.out.println("No. of adults travelling are"+" "+tickets);
		
		Thread.sleep(2000);
		driver.quit();
		
		//driver.findElement(By.className("css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep")).click();

	}

}
