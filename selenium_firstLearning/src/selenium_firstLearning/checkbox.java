package selenium_firstLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkbox {

	public static void main(String[] args) {
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
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		List<WebElement> checkboxs = driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		int checkboxcount = checkboxs.size();
		System.out.println("Total checkboxes on the page are"+" "+ checkboxcount);

	}

}
