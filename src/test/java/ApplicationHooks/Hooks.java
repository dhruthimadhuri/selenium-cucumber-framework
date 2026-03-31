package ApplicationHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.ConfigReader;
import Utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private WebDriver driver;
	
	
	@Before (order = 0)
	public void setup(){
		
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(ConfigReader.get("url"));
	}
	
	@After(order=0)
	public void tearDown(Scenario scenario) {

	    if (scenario.isFailed()) {
	    	String screenshotname = scenario.getName().replaceAll(" ","_");
	        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
	                .getScreenshotAs(OutputType.BYTES);

	        scenario.attach(screenshot, "image/png", screenshotname);
	    }

	    DriverFactory.quitDriver();
	}

}
