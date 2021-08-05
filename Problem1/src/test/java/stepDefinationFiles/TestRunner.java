package stepDefinationFiles;


import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/Resources/Features"
					,glue = {"StepDefinations"}
					,monochrome = true
					,plugin = {"pretty", "junit:target/JunitReports/report.xml",
							"json:target/JsonReports/report.json",
							"html:target/HtmlReports/report.html"}
				)
public class TestRunner {
	
WebDriver driver = null;
	
	@Before
	public void steUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    driver.get("https://www.exercise1.com/values/");
	    driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
		
	}
	
	
}
