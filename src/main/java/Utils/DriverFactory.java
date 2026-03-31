package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;
	
	//String browser = config.prop.getProperty("browser"); -->works when properties are made public
	
	public static WebDriver init_driver(){
	//String browser = config.get("browser","chrome");
	if (driver != null) {
	    return driver;
	}
	String browser = ConfigReader.get("browser","Chrome").toLowerCase(); // to make sure the default values match the switch case

	switch (browser) {
    case "chrome":
        WebDriverManager.chromedriver().setup(); // Ensures ChromeDriver is downloaded
        driver = new ChromeDriver();
        break;
    case "edge":
        WebDriverManager.edgedriver().setup();   // Ensures EdgeDriver is downloaded
        driver = new EdgeDriver();
        break;
    case "firefox":
        WebDriverManager.firefoxdriver().setup(); // Ensures GeckoDriver is downloaded
        driver = new FirefoxDriver();
        break;
    default:
        throw new RuntimeException("Invalid browser: " + browser);
}
	driver.manage().window().maximize();
	return driver;
//	if (browser.equalsIgnoreCase("chrome")) {
//	//WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	else if (browser.equalsIgnoreCase("Edge")) {
//		driver= new EdgeDriver(); //didnt include webdriver manager as using selenium 4.6 as Selenium Manager handles the driver automatically	
//	}
//	else if (browser.equalsIgnoreCase("Firefox")) {
//		driver= new FirefoxDriver(); //didnt include webdriver manager as using selenium 4.6 as Selenium Manager handles the driver automatically	
//	}
//	else
//		throw new RuntimeException("Invalid browser: " + browser);
//	driver.manage().window().maximize();
//	return driver;
	
	//driver.set(new ChromeDriver()); --> this is available only threadlocal<>-->parallel execution
	}

	public static  WebDriver getDriver() {
		if(driver == null)
			init_driver();
	    return driver;
	}
	public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
}
}
