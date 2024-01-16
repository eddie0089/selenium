package selenium_firstLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class traverse_parentChild_withoutIndex {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//The below code is to work on the xpath when indexing are not allowed in the project
		
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
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='ATQ']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
	}

}
