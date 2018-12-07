package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.reporters.Files;

public class Screenshot {
	WebDriver driver;
	public Screenshot(WebDriver driver) {
		this.driver=driver;	
	}
		public void getScreenshot(String scriptName) {
			EventFiringWebDriver efw= new EventFiringWebDriver(driver);
	File srcFile =efw.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./screeshots/"+scriptName+".png");
Files.copyFile( srcFile,destFile);
}
}
