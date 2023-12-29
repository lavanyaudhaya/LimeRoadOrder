package com.cucumber_base_class;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	
public abstract class LimeRoad_BaseClass {
	
	public static JavascriptExecutor jse;
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static TakesScreenshot screenShot;
	public static Select select;
	
	//Browser Launch & maximizing the window using WebdriverManager
	public static WebDriver launchBrowser(String browserName) {
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}

	driver.manage().window().maximize();
	return driver;	
	}
	
	//Url launch method
	public static WebDriver launchURL(String url) {
		driver.get(url);
		return driver;
	}
	
	public static void closeBrower() {
		driver.close();
	}
	
	public static void clickElement(WebElement element) {	
		element.click();		
	}
	
	public static void redirectTo(String url) {
		driver.navigate().to(url);
	}

	public static void mouseHoverElement(WebElement element) {	
		if(action == null) {
			action = new Actions(driver);
		}
		action.moveToElement(element).build().perform();		
	}
	
	public static void mouseHoverElementAndClick(WebElement element) {	
		if(action == null) {
			action = new Actions(driver);
		}
	
		action.moveToElement(element).build().perform();
		action.click().build().perform();
	}
	
	public static void scrollDown(WebElement element) {
		jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	public static void elementClickWithJSE(WebElement element) {
		jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].click();", element);
		
	}
	
	public void implicitWait(int seconds) {		
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void waitForElementToBeClicked(WebElement element) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	public static void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void takeScreenShot(String fileName) throws IOException {
		screenShot = (TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\AutomationTraining\\Lime_Road_Cucumber_TestingDemo\\Screenshots\\" +fileName+ ".png");
		FileUtils.copyFile(source,destination);
	}	
	
	
public static void getWindowID(String pageId) {
		
		pageId = driver.getWindowHandle();		
		System.out.println("Page id is: "+ pageId);
		System.out.println("Url of this page is "+driver.getCurrentUrl());
		System.out.println("Title of this page is: "+driver.getTitle());
	}
		
	public static void getWindowIdForMultipleTabs() {
		
		Set<String> listOfWindows =driver.getWindowHandles();
		System.out.println("The set of windows opened are: ");
		for(String windowsList: listOfWindows) {
			System.out.println(windowsList);
		}
	}
	
	public static void getMultipleWindowIds() throws InterruptedException {

		Set<String> listOfWindowsSet =driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(listOfWindowsSet);
		int lastElementId;
		lastElementId = listOfWindows.size() - 1;
		driver.switchTo().window(listOfWindows.get(lastElementId));
		Thread.sleep(3000);
	}
	
	public static void selectDropDown(WebElement element, String weight) {
		select = new Select(element);
		List<WebElement> dropDownOptionList = select.getOptions();
		int i;
		for(i=0;i<dropDownOptionList.size();i++) {
			if(dropDownOptionList.get(i).getText().equals(weight)) {
				select.selectByVisibleText(weight);
			}
		}
	}	

	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
}
