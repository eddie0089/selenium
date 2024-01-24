package selenium_firstLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionClassMouseInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="https://www.amazon.in";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		//options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(url);
		
		Actions a = new Actions(driver);
		WebElement move=driver.findElement(By.id("nav-link-accountList"));
		
		a.moveToElement(driver.findElement(By.cssSelector("input[type='text']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform();

	}

}
