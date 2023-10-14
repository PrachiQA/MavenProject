package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https://extendsclass.com/text-compare.html");
		// Maximize window
		driver.manage().window().maximize();
		WebElement sourceText = driver
				.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[5]/pre"));
		WebElement destText = driver
				.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[2]/pre"));
		Actions actions = new Actions(driver);
		actions.keyDown(sourceText, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);
		actions.keyDown(destText, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		// Close browser
		driver.quit();

	}

}
