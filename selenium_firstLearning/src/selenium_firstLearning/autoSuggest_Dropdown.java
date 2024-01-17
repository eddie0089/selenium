package selenium_firstLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class autoSuggest_Dropdown {

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
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		
		List<WebElement> myCountry=driver.findElements(By.className("ui-menu-item"));
		
		for (WebElement country: myCountry) {
			
			if(country.getText().equalsIgnoreCase("India")) {
			country.click();
			break;
		}

	}
 }		
}

