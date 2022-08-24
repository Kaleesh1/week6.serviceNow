package week6.servicenowAssign;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesForceShadowDom {
	ChromeDriver driver;
	Shadow dom;
	Alert al;
@Test
	public void sales() throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		dom=new Shadow(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		ChromeOptions o = new ChromeOptions(); 
		o.addArguments("--disable-notifications");
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winhanlst = new ArrayList<String>(windowHandles);
		String mobPubwin = winhanlst.get(1);
		
		driver.switchTo().window(mobPubwin);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		driver.findElement(By.xpath("//*[@id=\"onetrust-reject-all-handler\"]")).click();
		
		WebElement learning = dom.findElementByXPath("//span[text()='Learning']");
		learning.click();

		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement learning = (WebElement)js.executeScript("return document.querySelector('hgf-c360nav').shadowRoot.querySelector('header > div > div > nav:nth-child(3) > ul > li:nth-child(3) > h3 > hgf-button > span')");
		learning.click();
		WebElement learningOnTrailhead = (WebElement)js.executeScript("return document.querySelector('hgf-c360nav').shadowRoot.querySelector('header > div > div > nav:nth-child(3) > ul > li:nth-child(3) > div > div > div > ul > li > hgf-button > div > span')");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(learningOnTrailhead).perform();*/
		
}
}