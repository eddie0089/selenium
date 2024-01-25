package selenium_firstLearning;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multiWindowGetText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://the-internet.herokuapp.com/";		
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		String firstWindow=it.next();
		String secondWindow=it.next();
		
		driver.switchTo().window(secondWindow);
		
		String text2=driver.findElement(By.tagName("h3")).getText();
		System.out.println(text2);
		
		driver.switchTo().window(firstWindow);
		String text=driver.findElement(By.tagName("h3")).getText();
		System.out.println(text);
		
		driver.quit();
		
	}

}
