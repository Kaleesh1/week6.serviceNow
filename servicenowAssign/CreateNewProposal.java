package week6.servicenowAssign;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewProposal extends ProjectSpecificMethods{
	
	@Test
	public void createNewprop() throws InterruptedException {
		//Click All
		Thread.sleep(30000);
		WebElement allClick = dom.findElementByXPath("//div[@id='all']");
		allClick.click();
		
		//Type proposals in filter and click enter
		Thread.sleep(2000);
		WebElement clickFilterField = dom.findElementByXPath("//input[@id='filter']");
		clickFilterField.click();
		clickFilterField.sendKeys("Proposal");
		allClick.click();
		clickFilterField.click();
		clickFilterField.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		//get initial proposal page title
		String initialProPage = driver.getTitle();
		System.out.println(initialProPage);
		
		//Click new to create a proposal
		WebElement iframe = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframe);
		WebElement clickNew = dom.findElementByXPath("//button[text()='New']");		
		clickNew.click();
		
		//get the new proposal number
		WebElement findProNumber = dom.findElementByXPath("//input[@id='std_change_proposal.number']");
		String propoNum = findProNumber.getAttribute("Value");
		
		//type proposal temp and work description
		WebElement tempDesc = dom.findElementByXPath("//input[@id='std_change_proposal.short_description']");
		tempDesc.sendKeys("TEST4");
		WebElement workNotes = dom.findElementByXPath("//textarea[@id='std_change_proposal.work_notes']");
		workNotes.sendKeys("This is to test proposal");
		
		//switch to change request values TAB
		WebElement switchToCRValTab = dom.findElementByXPath("//span[text()='Change Request values']");
		builder.moveToElement(switchToCRValTab).perform();
		switchToCRValTab.click();
		
		//Find initial Form value
		Thread.sleep(5000);
		WebElement shortDec = dom.findElementByXPath("//span[@class='select2-chosen']");
		shortDec.click();
		WebElement shortDecSel = dom.findElementByXPath("//label[@for='s2id_autogen6_search']/following-sibling::input[1]");
		shortDecSel.click();
		
		//use Tab and Enter key navigation to fill teh form
		shortDecSel.sendKeys("Review comments",Keys.ENTER,Keys.TAB,"Short Desc",Keys.TAB,Keys.TAB,Keys.ENTER,"Assignment group",Keys.ENTER,Keys.TAB,"Desc Desc", Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER,"Impact",Keys.ENTER,Keys.TAB,"1", Keys.TAB,Keys.TAB,Keys.ENTER, "Risk and impact analysis",Keys.ENTER,Keys.TAB,"BreakoutPlan",Keys.TAB,Keys.TAB,Keys.ENTER, "Scope",Keys.ENTER,Keys.TAB,"Large",Keys.TAB,Keys.TAB,Keys.ENTER,"Category",Keys.ENTER,Keys.TAB);
		
		//using select class choose dropdown value
		WebElement drpdwn1 = dom.findElementByXPath("//td[@data-value='Category']//select[1]");
		drpd = new Select(drpdwn1);
		drpd.selectByVisibleText("Hardware");
		
		//Click n submit button
		WebElement submit = dom.findElementByXPath("//button[@id='sysverb_insert_bottom']");
		builder.moveToElement(submit).perform();
		submit.click();
		
		//Get page title after submitting proposal
		String afterSubProPage = driver.getTitle();
		System.out.println(afterSubProPage);
		
		//Check if the initial page title before creating new proposal is same as the title of page after creating proposal if yes print the proposal number
		if (initialProPage.equalsIgnoreCase(afterSubProPage)) {
			
			System.out.println("Proposal"+ propoNum +"Created Successully");
		}
	}

}
