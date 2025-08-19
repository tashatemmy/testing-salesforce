package salesforce.au_Tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	String url = "https://salesforce.com/au";
	
	
	
	@BeforeTest
	public void setup() {
		//use "env = browserstack" or "env = local"
		String env = System.getProperty("env", "browserstack");
		
		if(env.equalsIgnoreCase("browserstack")){
			 // BrowserStack SDK handles driver init automatically
            // Just call ChromeDriver (or any driver) and SDK reroutes it
			
			driver = new ChromeDriver();
			
		}
		
		if(env.equalsIgnoreCase("local")) {
			String browser = System.getProperty("browser", "chrome");
			
			switch (browser.toLowerCase()) {
            case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
            case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			}
			
		}
		System.out.println("Running test in environment: " + env + "..");
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	


}
