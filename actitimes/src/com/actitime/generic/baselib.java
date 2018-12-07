package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baselib {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp(String browserName, String url) {
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver= new FirefoxDriver();
			Reporter.log("FireFox Launched", true);
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver= new ChromeDriver();
			Reporter.log("Chrome Launched",true);
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			Reporter.log("IE Launched",true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("navigated to url"+url, true);
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess()) {//true..>pass
			Reporter.log(scriptName+" Script is passed :)",true);
		
			
		}
		else //false..>failed
		{
			Screenshot slib= new Screenshot(driver);//b=c
			slib.getScreenshot(scriptName);
			Reporter.log("ScreenShot has been taken", true);
			
		}
		driver.close();
		Reporter.log("Browser is closed", true);
		
		
	}

}








