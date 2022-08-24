package week6.servicenowAssign;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewCaller extends ProjectSpecificMethods{
	
	@Test
	public void createNewCaller() throws InterruptedException {
		//Click All
		Thread.sleep(30000);
		WebElement allClick = dom.findElementByXPath("//div[@id='all']");
		allClick.click();
		
		//Type caller in filter and click enter
		Thread.sleep(2000);
		WebElement clickFilterField = dom.findElementByXPath("//input[@id='filter']");
		clickFilterField.click();
		clickFilterField.sendKeys("Caller");
		allClick.click();
		clickFilterField.click();
		clickFilterField.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		//get initial caller page title
		String initialcallPage = driver.getTitle();
		System.out.println(initialcallPage);
		
		//Click new to create a caller
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement clickNew = dom.findElementByXPath("//button[text()='New']");		
		clickNew.click();
		
		//Enter First name
		WebElement firstName = dom.findElementByXPath("(//span[text()='First name']/following::input)[2]");
		firstName.click();
		firstName.sendKeys("Sebastian");
		
		//Enter Last name
		WebElement lastName = dom.findElementByXPath("(//span[text()='Last name']/following::input)[2]");
		lastName.click();
		lastName.sendKeys("Vettel");
		String contact = lastName.getAttribute("Value");
		
		//Enter Title
		WebElement title = dom.findElementByXPath("(//input[@data-ref='sys_user.title'])[2]");
		title.click();
		title.sendKeys("Driver");
		
		//Enter email
		WebElement email = dom.findElementByXPath("(//span[text()='Email']/following::input)[2]");
		email.click();
		email.sendKeys("Driver");
		
		//Click n submit button
		WebElement submit = dom.findElementByXPath("//button[@id='sysverb_insert_bottom']");
		submit.click();
		
		//Get page title after submitting proposal
		String aftercreateCallerPage = driver.getTitle();
		System.out.println(aftercreateCallerPage);
		
		//Check if the initial page title before creating new proposal is same as the title of page after creating proposal if yes print the proposal number
		if (initialcallPage.equalsIgnoreCase(aftercreateCallerPage)) {
			
			System.out.println("Contact"+ contact +"Created Successully");
		}
	}

}
