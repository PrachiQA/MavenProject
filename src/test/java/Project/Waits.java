package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https:\\\\www.eBay.com");
		// Maximize window
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		actions.moveToElement(element).perform();
		/*// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
		/*// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")))).click();*/
		//Fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Custom message")
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")))).click();
		// Close browser
		driver.quit();

	}

}
