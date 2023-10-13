package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InertAutomation {

	public static void main(String[] args) throws InterruptedException {

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// Navigate to URL
		driver.get("https://www.inert.online/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Click on Shop weblement
		driver.findElement(By.xpath("//p[text()='Shop']")).click();
		// Create actions object
		Actions actions = new Actions(driver);
		// Specify the target element to scroll until it becomes visible (using its ID
		// in this example)
		By targetElementLocator = By
				.xpath("//div[@data-slug='gourmet-vanilla-proteinbar']//span[text()='Add to Cart']");
		// Keep pressing the down arrow key until the target element becomes visible
		while (driver.findElements(targetElementLocator).isEmpty()) {
			actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).perform();
		}
		Thread.sleep(5000);
		// Once the target element is visible, you can perform actions on it
		driver.findElement(targetElementLocator).click();
		Thread.sleep(5000);
		By viewMoreDetailsButton = By.xpath("//a[@data-hook='quick-view-more'][text()='View More Details']");
		// First finding the element using any of locator stratedgy
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Gourmet Vanilla Protein Bar']"));
		// now using the switch command
		driver.switchTo().frame(iframeElement);
		driver.findElement(viewMoreDetailsButton).click();

		List<WebElement> allTagsList = driver.findElements(By.tagName("a"));
		System.out.printf("Total tags are:", +allTagsList.size());

		for (int i = 0; i < allTagsList.size(); i++) {
			System.out.println(allTagsList.get(i).getAttribute("href"));
			System.out.println(allTagsList.get(i).getText());
		}
		
		driver.quit();
	}
}
