package selenium_firstLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class productCartProblem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/seleniumPractise/#/";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		
		List<WebElement> myVegetables=driver.findElements(By.cssSelector("h4.product-name"));
		for (int i=0; i<myVegetables.size();i++) {
			String veg=myVegetables.get(i).getText();
			
			if(veg.contains("Cauliflower")) {
				driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
		
	}
}
