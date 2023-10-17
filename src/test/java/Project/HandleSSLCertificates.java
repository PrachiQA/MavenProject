package Project;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSSLCertificates {

	public static void main(String[] args) {
		// setup webdriver
		WebDriverManager.firefoxdriver().setup();
		// create desired capabalities instance
		DesiredCapabilities handleSSL = new DesiredCapabilities();
		handleSSL.setAcceptInsecureCerts(true);
		// chromeoption
		FirefoxOptions co = new FirefoxOptions();
		co.merge(handleSSL);
		// create chromedriver instance
		FirefoxDriver driver = new FirefoxDriver(co);
		// get url
		driver.get("https://expired.badssl.com/");
		// maximize window
	
		//Note: not working for chromedriver
	}

}
