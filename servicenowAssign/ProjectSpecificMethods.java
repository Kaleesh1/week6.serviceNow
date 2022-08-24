package week6.servicenowAssign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ProjectSpecificMethods {
	
	ChromeOptions options;
	ChromeDriver driver;
	Actions builder;
	String ordCnf="Thank you, your request has been submitted";
	Shadow dom;
	
	public static Select drpd;
	
	@Parameters({"url", "uname", "pass"}) 
	@BeforeMethod
	public void setup(String url, String uname, String pass) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		driver = new ChromeDriver();
		builder = new Actions(driver);
		dom=new Shadow(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200000));
		
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pass);
		driver.findElement(By.id("sysverb_login")).click();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
