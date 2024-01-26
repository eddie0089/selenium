package selenium_firstLearning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class autoCompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://qaclickacademy.com/practice.php";		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("uni");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-menu-item-wrapper")));
		List<WebElement> countries=driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		
		for (WebElement myCountry: countries) {
			if (myCountry.getText().contains("United States")) {
				myCountry.click();
				
				break;
			}
		}
			
	}

}
