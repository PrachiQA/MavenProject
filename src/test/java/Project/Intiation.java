package Project;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intiation {

	public static void main(String[] args) {
		// Google Chrome
		// Set chromedriver executables path for controlling chrome browser
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\EnvironmentSetup\\BrowserDrivers\\chromedriver.exe");*/
		WebDriverManager.chromedriver().setup();
		// Create instance of chromedriver class and name it as variable driver
		ChromeDriver driverCD = new ChromeDriver();
		// Navigate browser to URL
		driverCD.get("https:\\www.eBay.com");
		driverCD.manage().window().maximize();
		driverCD.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile");
		driverCD.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		driverCD.close();
		// Close browser
		driverCD.quit();

		// Mozilla Firefox
		// Set FFdriver executables path for controlling FF browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\EnvironmentSetup\\BrowserDrivers\\geckodriver.exe");
		// Create instance of chromdriver class and name it as variable driver
		FirefoxDriver driverFF = new FirefoxDriver();
		// Navigate browser to URL
		driverFF.get("https:\\www.google.com");
		// Close browser
		driverFF.quit();

		// Microsoft Edge
		// Set edgedriver executables path for controlling edge browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\EnvironmentSetup\\BrowserDrivers\\msedgedriver.exe");
		// Create instance of chromdriver class and name it as variable driver
		EdgeDriver driverEdge = new EdgeDriver();
		// Navigate browser to URL
		driverEdge.get("https:\\www.google.com");
		// Close browser
		driverEdge.quit();
		
	}
}
