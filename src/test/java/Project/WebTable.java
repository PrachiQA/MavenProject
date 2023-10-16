package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Instantiate chromedriver
		ChromeDriver driver = new ChromeDriver();
		// Open cosmocode URL
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		// Maximize window
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[1]"))).perform();
		// Get row size of the table
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
		System.out.println("row size is :" + rows.size());
		int rowSize = rows.size();

		// Get column size of the table
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr[1]/td"));
		System.out.println("Column size is :" + columns.size());
		int colSize = columns.size();

		// iterate rows an columns
		for (int i = 1; i <= rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {
				WebElement element = driver
						.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.println(element.getText());
			}
		}
		// close browser
		driver.close();

	}

}
