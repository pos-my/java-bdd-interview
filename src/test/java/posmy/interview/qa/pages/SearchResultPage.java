package posmy.interview.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import posmy.interview.qa.util.TestBase;

public class SearchResultPage extends TestBase{

	@FindBy(xpath="//span[@title='Overview']")
	WebElement sidebar_Overview;
	
	@FindBy(xpath="//span[@title='Testing']")
	WebElement sidebar_Testing;
	
	@FindBy(xpath="//a[@data-ti='Latest']//div/div")
	WebElement TopStoriesLabel;
	
	@FindBy(xpath="//h2[@class='JolIg V88cHc']")
	WebElement CommonQuestionsLabel;
	
	@FindBy(xpath="//a[@href='http://covid-19.moh.gov.my/']")
	WebElement MOHLink;
	
	//Initialize Page Objects
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSidebar_Overview() {
		sidebar_Overview.click();
	}
	
	public void clickSidebar_Testing() {
		sidebar_Testing.click();
	}
	
	public String validateTopStoriesLabel() {
		return TopStoriesLabel.getAttribute("innerText");
	}
	
	public String validateCommonQuestionsLabel() {
		return CommonQuestionsLabel.getAttribute("innerText");
	}
	
	public MOHPage clickMOHLink() {
		MOHLink.click();
		return new MOHPage();
	}
	
}
