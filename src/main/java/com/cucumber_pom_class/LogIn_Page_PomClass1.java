package com.cucumber_pom_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber_base_class.LimeRoad_BaseClass;

public class LogIn_Page_PomClass1 extends LimeRoad_BaseClass{
	
	//public WebDriver driver;
	
	public LogIn_Page_PomClass1() {
		//driver = driver1;
		//PageFactory.initElements(driver, driver1);
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath = "//span[text() ='SHOP MEN']")
	private WebElement shopMen;
	public WebElement getShopMen() {
		return shopMen;
	}
	
	
			
	
	
	
	
	
	
	
	

}
