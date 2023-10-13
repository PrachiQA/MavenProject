package Project;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == "chrome") {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == "edge") {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		/*
		 * driver.manage().window().maximize(); driver.get("https://www.saucedemo.com");
		 * //driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 * WebElement element = driver.findElement(By.id("password"));
		 * element.sendKeys("secret_sauce"); By NameLocator =
		 * RelativeLocator.with(By.tagName("input")).above((element));
		 * driver.findElement(NameLocator).sendKeys("standard_user");
		 * driver.findElement(By.xpath(
		 * "//html/body/div/div/div[2]/div[1]/div/div/form/input")).click();
		 * driver.close();
		 */

		// Basic methods in Webdriver interface
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		String currentPageTitle = driver.getTitle();
		System.out.println(currentPageTitle);

		String currentPageSource = driver.getPageSource();
		System.out.println(currentPageSource);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		WebElement element = driver.findElement(By.id("password"));
		element.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//html/body/div/div/div[2]/div[1]/div/div/form/input")).click();

		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_container']/div"));
		System.out.println(webelements);
		
		driver.navigate().to("https://support.google.com/");
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		driver.findElement(By.xpath("//a[@class='product-icon']/span[text()='Google']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		
		

//		driver.navigate().to("https://www.google.com");
//		driver.close();
	}

}
