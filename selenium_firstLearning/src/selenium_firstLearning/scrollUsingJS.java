package selenium_firstLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class scrollUsingJS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url= "https://rahulshettyacademy.com/AutomationPractice/";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		
		WebElement table=driver.findElement(By.cssSelector(".tableFixHead"));
		
		List<WebElement> totalAmount=table.findElements(By.cssSelector("td:nth-child(4)"));
		int count=totalAmount.size();
		int sum=0;
		
		for (int i=0;i<count;i++) {
			String amount=totalAmount.get(i).getText();			
			int myValue=Integer.parseInt(amount);
			sum=sum+myValue;			
		}
		System.out.println(sum);
		driver.quit();

	}

}
