package posmy.interview.qa.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import posmy.interview.qa.driver.RemoteWebDriverFactory;
import posmy.interview.qa.pages.GoogleHomePage;
import posmy.interview.qa.pages.MOHPage;
import posmy.interview.qa.pages.SearchResultPage;

public class TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static WebDriver driver;
	public static Properties prop;
	
	protected GoogleHomePage hp;
	protected SearchResultPage srp;
	protected MOHPage mp;
	
	public TestBase() {
		String propFileName = "config.properties";
		try {
			prop = new Properties();
			InputStream in = getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		driver = RemoteWebDriverFactory.chrome();
		
		driver.manage().window().maximize(); //launch browser in maximize 
		driver.manage().deleteAllCookies(); //clear all cookies
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//Log.info("app url is:" + prop.getProperty("url"));
		initPageObject();
	}
	
	public void initPageObject() {
		hp = new GoogleHomePage();
		srp = new SearchResultPage();
		mp = new MOHPage();
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}

