package week6.servicenowAssign;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


@Test
public class Mobile extends ProjectSpecificMethods  {


	public void mobile() throws InterruptedException {

	//Selecting all form shadow DOM
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(20000);
		WebElement all = (WebElement)js.executeScript("return document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010').shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout').shadowRoot.querySelector('div > div > sn-polaris-header').shadowRoot.querySelector('nav > div > div:nth-child(6) > div:nth-child(2) > div')");
		all.click();
		
		//Selecting search form shadow DOM and entering search text
		Thread.sleep(3000);
		WebElement search = (WebElement)js.executeScript("return document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010').shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout').shadowRoot.querySelector('div[class=\"sn-polaris-layout polaris-enabled\"] > div:nth-child(3) > sn-polaris-header').shadowRoot.querySelector('nav > div > sn-polaris-menu').shadowRoot.querySelector('nav >div:nth-child(2) > div > div > input:nth-child(2)')");
		search.click();
		search.sendKeys("Service catalog");
		
		//Re-doing clicks to enter service catalog page
		all.click();
		search.click();
		search.sendKeys(Keys.ENTER);
		
		Thread.sleep(10000);
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		//WebElement mobilePag = dom.findElementByXPath("//a[text()='Mobiles']");
		driver.switchTo().frame(iframe);
		//Switch to frame
		//driver.switchTo().frame("gsft_main");

		//Clicking on mobile page
		driver.findElement(By.linkText("Mobiles")).click();
		
		//Selecting iPhone 6s
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		
		//Color selection
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Touch ID ']"));
		builder.scrollToElement(findElement);
		
		WebElement colorDrp = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")); 
		Select colorDrp1 = new Select(colorDrp);
		colorDrp1.selectByValue("gold");

		//Order Button click
		driver.findElement(By.id("oi_order_now_button")).click();
		
		
		String thankYouYour = driver.findElement(By.xpath("//div[@class='notification notification-success']//span")).getText();
		
		if (thankYouYour.equals(ordCnf)) {
			WebElement findElement2 = driver.findElement(By.xpath("//dt[text()='Request Number: ']/following::b"));
			String text = findElement2.getText();
			System.out.println(text);
		}
	}

}

