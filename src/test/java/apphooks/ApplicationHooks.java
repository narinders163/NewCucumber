package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.narinderpal.singh.driver.DriverInitializer;
import com.narinderpal.singh.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverInitializer drinit;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_Prop();
	}
	
	@Before(order=1)
	public void getDriver() {
		drinit = new DriverInitializer();
		String browserName = prop.getProperty("browser");
		driver = drinit.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitDriver() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
	

}
