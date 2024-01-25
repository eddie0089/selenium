package selenium_firstLearning;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleMultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/loginpagePractise/";		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		String parentWindow=it.next();
		String childWindow=it.next();
		
		driver.switchTo().window(childWindow);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='JOIN NOW']")));
		
		String username=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("@")[1].trim().split(" ")[0].trim();
		
		System.out.println(username);
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div/label[2]/span[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select consul = new Select(dropdown);
		
		driver.quit();
		
		
		
		

	}

}
