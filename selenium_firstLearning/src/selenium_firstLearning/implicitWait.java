package selenium_firstLearning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class implicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/seleniumPractise/#/";
		//Declare an array to store the names of vegetables to be added in the cart
		String[] myList = {"Cucumber", "Brocolli", "Orange"};
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);	
		
		addToCart(driver, myList);	
		
		//Click on shopping bag
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("mycoupon");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		driver.quit();

	}
	
	public static void addToCart(WebDriver driver, String[] myList) {
		
		//
		
		
		////Get the list of vegetables from their names displayed on the UI
		List<WebElement> myVegetables=driver.findElements(By.cssSelector("h4.product-name"));
		
		//Iterate through the total no. of elements based on above element locator
		for (int i=0; i<myVegetables.size();i++) {
			
			//Get the text of each vegetable like Cauliflower - 1 Kg, Brocolli - 1 Kg etc.
			String[] veg=myVegetables.get(i).getText().split("-");
			//Need to split the names displayed on the UI by '-' and trim to remove space			
			
			String mySelection=veg[0].trim();	
			//Convert the array into ArrayList
			List myVeggie=Arrays.asList(myList);
			
			//Now condition to check if myVeggie list contains names of vegetable stored in mySelection and then add to cart
			if(myVeggie.contains(mySelection)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
		
	}

}
