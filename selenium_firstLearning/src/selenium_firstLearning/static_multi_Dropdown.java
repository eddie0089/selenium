package selenium_firstLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class static_multi_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://chercher.tech/practice/practice-dropdowns-selenium-webdriver";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement selectDropdown=driver.findElement(By.className("col-lg-3"));
		Select dropdown = new Select(selectDropdown);
		
		dropdown.selectByValue("Google");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("Bing");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		WebElement multiSelect=driver.findElement(By.cssSelector("#second.col-lg-3"));
		Select dropdown2 = new Select(multiSelect);
		
		//List<WebElement> list=dropdown2.getOptions();
		dropdown2.selectByVisibleText("Pizza");
		System.out.println(dropdown2.getFirstSelectedOption().getText());
		dropdown2.selectByValue("donut");
		
		dropdown2.selectByIndex(3);
		dropdown2.deselectAll();
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
