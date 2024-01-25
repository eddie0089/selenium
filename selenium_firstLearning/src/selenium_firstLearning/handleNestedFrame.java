package selenium_firstLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleNestedFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="https://the-internet.herokuapp.com/";		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
		
		String text=driver.findElement(By.xpath("//*[text()='MIDDLE']")).getText();
		System.out.println(text);
		
		driver.quit();

	}

}
