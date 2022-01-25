package posmy.interview.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws InterruptedException {
		String text ="Top stories";
		System.setProperty("webdriver.chrome.driver","C:\\dr\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com");
		WebElement elem = wd.findElement(By.name("q"));
		elem.sendKeys(new String[] { "covid 19 in Malaysia" });
		elem.submit();
		
		Thread.sleep(2000);

		if(wd.getPageSource().contains("Top stories")){
			System.out.println("Text is present");
		}else{
			System.out.println("Text is absent");
		}
		
		wd.findElement(By.partialLinkText("COVID-19 MALAYSIA: Home")).click();
		Thread.sleep(3000);
		
		String url = wd.getCurrentUrl();
		System.out.println(url);
		wd.quit();
	}

}
