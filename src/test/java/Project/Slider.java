package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https://jqueryui.com/slider/");
		// Maximize window
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		// Switch to Frame
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		// Find element
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		// perform drag and drop action
		actions.dragAndDropBy(slider, 50, 50).perform();
		// Close browser
		driver.quit();
	}

}
