package selenium_firstLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;

public class basicSeleniumMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//This command will locate the driver in your system for chrome browser
		String username="student";
		String password="Password123";
		String message="Logged In Successfully";
		String url="https://practicetestautomation.com/practice-test-login/";
		System.setProperty("webdriver.chrome.driver", "/Users/eddie/Learning/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//launch the website
		driver.get(url);
		
		
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("btn")).click();
		
		String screenmsg=driver.findElement(By.className("post-title")).getText();
		System.out.println(screenmsg);
		System.out.println(driver.getTitle());
		Assert.assertEquals(message,screenmsg);
		
		Thread.sleep(2000);
		driver.close();

	}

}
