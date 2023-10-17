package Project;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		// Setup webdriver
		WebDriverManager.chromedriver().setup();
		// Create a chromedriver instance
		ChromeDriver driver = new ChromeDriver();
		// Get droppable Jquery URL
		driver.get("https:\\\\www.eBay.com");
		// Maximize window
		driver.manage().window().maximize();
		//Date
		Date date = new Date();
		System.out.println(date);
		String screenshotFileName = date.toString().replace(" ", "-").replace(":", "-");
		//take screeshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//added dependecy in pom as well
		FileUtils.copyFile(screenshotFile, new File(".//Screenshots//"+screenshotFileName+".png"));
		// Close driver
		driver.close();
	}

}
