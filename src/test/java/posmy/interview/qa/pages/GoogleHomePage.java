package posmy.interview.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import posmy.interview.qa.util.TestBase;

public class GoogleHomePage extends TestBase{
	
	//Page Factory or Object Repository
	@FindBy(xpath="//input[@aria-label='Search']")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//input[@value='Google Search']")
	WebElement searchSubmitBtn;

	
	//Initialize Page Objects
	public GoogleHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods
	public String validateGooglePageTitle() {
		return driver.getTitle();
	}
	
	public void EnterSearchkeyword(String keyword) {
		searchTxtBox.sendKeys(keyword);
	}
	
	public void clickGoogleSearchButton() {
		searchSubmitBtn.click();
	}
}
