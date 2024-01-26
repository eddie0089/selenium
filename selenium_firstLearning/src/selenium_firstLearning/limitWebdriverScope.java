package selenium_firstLearning;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class limitWebdriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get(url);
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer= driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement firstColumn=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		
		//CLick on each link to open in a separate window
		
		for (int i=1; i<firstColumn.findElements(By.tagName("a")).size(); i++){
			
			String clickOnLinks=Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);			
		}			
			//Moving to each link and getting the title of the page
			
			String parentHandle = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();			
			
			Iterator<String> it = windowHandles.iterator();
			
			while(it.hasNext()) {
				
				String childHandle = it.next();
				if(!parentHandle.equalsIgnoreCase(childHandle)) {
					driver.switchTo().window(childHandle);
					System.out.println(driver.getTitle());
				}
			}
			driver.switchTo().window(parentHandle);
			System.out.println(driver.getTitle());
			driver.quit();
						
		}
		
	}
