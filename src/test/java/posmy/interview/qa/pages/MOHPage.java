package posmy.interview.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import posmy.interview.qa.util.TestBase;

public class MOHPage extends TestBase{

	//Page Factory or Object Repository	
	@FindBy(xpath="//img[@alt='COVID-19 Malaysia']")
	WebElement logoImg;

	
	//Initialize Page Objects
	public MOHPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or Methods
	public String get_MOHPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean MOHPageLogo_Displayed() {
		return logoImg.isDisplayed();
	}
	
}
