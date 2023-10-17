package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Create a chromedriver instance
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		// Maximize window
		driver.manage().window().maximize();

		// Create a JavaScriptExecutor instance to execute JavaScript code
		JavascriptExecutor jsexec = (JavascriptExecutor) driver;

		// print the title of the page
		String script = "return document.title;";
		String title = (String) jsexec.executeScript(script);
		System.out.println(title);

		// Click button and accept alert
		driver.switchTo().frame("iframeResult");
		jsexec.executeScript("myFunction()");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// Hightlight element
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		jsexec.executeScript("arguments[0].style.border='5px solid green'", button);

		// scroll to element
		driver.navigate().to("https://www.w3schools.com/");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/h1"));
		jsexec.executeScript("arguments[0].scrollIntoView(true)", element);

		// Close driver
		driver.close();
	}

}
