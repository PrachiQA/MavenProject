package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resize {

	public static void main(String[] args) {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https://jqueryui.com/resizable/");
		// Maximize window
		driver.manage().window().maximize();
		WebElement scrollToElement = driver.findElement(By.xpath("//*[@Class='demo-description']"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(scrollToElement).perform();
		// Switch to Frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		// Find element
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		// perform drag and drop action
		actions.dragAndDropBy(resize, 50, 50).perform();
		// Close browser
		driver.quit();
	}

}
