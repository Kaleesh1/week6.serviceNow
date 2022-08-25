package week6.servicenowAssign;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewCallerFire extends ProjectSpecificMethodsFire{
	
	@Test
	public void createNewCaller() throws InterruptedException {
		//Click All
		dom.setImplicitWait(15);
		WebElement allClick = dom.findElementByXPath("//div[@id='all']");
		allClick.click();
		
		//Type caller in filter and click enter
		WebElement clickFilterField = dom.findElementByXPath("//*[@id='filter']");
		builder.moveToElement(clickFilterField).click(clickFilterField).sendKeys("caller").perform();
		WebElement clickCallers = dom.findElementByXPath("//a[@aria-label='Callers']");
		builder.moveToElement(clickCallers).click().perform();

		//get initial caller page title
		Thread.sleep(6000);
		String initialcallPage = driver.getTitle();
		System.out.println(initialcallPage);
		
		//Click new to create a caller
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement clickNew = dom.findElementByXPath("//button[text()='New']");	
		clickNew.click();
		
		//Enter First name
		dom.setImplicitWait(60);
		WebElement firstName = dom.findElementByXPath("(//span[text()='First name']/following::input)[2]");
		builder.moveToElement(firstName).click(firstName).sendKeys("Sebastian").perform();
		
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
		
		WebElement searchCaller = dom.findElementByXPath("//input[@placeholder='Search']");
		searchCaller.sendKeys("Sebastian",Keys.ENTER);
		
		WebElement searchResult = dom.findElementByXPath("//*[@class=\"list_row list_odd/a");
		String callerName = searchResult.getText();
		
		if (contact.equals(callerName)) {
			System.out.println("New Caller" + callerName + "Created Successfully");
		}	
	}

}
