package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextMenuRightClick {

	public static void main(String[] args) throws InterruptedException {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https://jqueryui.com/slider/#colorpicker");
		// Maximize window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		// Switch to Frame
		WebElement frame = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(frame);
		// Find element
		WebElement rectangle = driver.findElement(By.xpath("//*[@id='red']"));
		// perform drag and drop action
		actions.contextClick(rectangle).perform();
		// Close browser
		driver.close();
	}

}
