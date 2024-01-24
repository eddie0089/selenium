package selenium_firstLearning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://rahulshettyacademy.com/loginpagePractise/";
		String username = "rahulshettyacademy";
		String password= "learning";
		String role = "consult";
		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(url);
		
		driver.manage().window().maximize();
		
		loginPage(username, password, driver, wait, role);
		addProduct(wait, driver);
		
		driver.quit();

	}
	
	public static void loginPage(String username, String password, WebDriver driver, WebDriverWait wait, String role) {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//div/label[2]/span[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select consul = new Select(dropdown);
		
		consul.selectByValue(role);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.form-control")));
		driver.findElement(By.cssSelector("select.form-control")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn")));
		driver.findElement(By.id("signInBtn")).click();	
		
	}
	
	public static void addProduct(WebDriverWait wait, WebDriver driver) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-link.btn.btn-primary")));
		List<WebElement> products=driver.findElements(By.cssSelector("h4.card-title"));
		
		for (int i =0; i<products.size(); i++) {
			
			driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
	}

}
