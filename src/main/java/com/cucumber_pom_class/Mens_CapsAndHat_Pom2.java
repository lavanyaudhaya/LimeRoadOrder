package com.cucumber_pom_class;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber_base_class.LimeRoad_BaseClass;

public class Mens_CapsAndHat_Pom2 extends LimeRoad_BaseClass{
	
	//LogIn_Page_PomClass1 - create object for this to loginto limeroad
	
	//Constructor to initialize driver for all the methods in here
	public Mens_CapsAndHat_Pom2() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath = "//span[text()='SHOP MEN']")
	private WebElement shopMen;
	public WebElement getShopMen() {
		return shopMen;
	}
	
	//Only Mouse Hover	
	@FindBy(xpath = "//a[@id='men_category']")
	private WebElement menTab;
	public WebElement getMenTab() {
		return menTab;
	}
	
	
	private String redirectUrl; 
		public String getredirectUrlString() {
			return redirectUrl; 
	}
	
	//Mover Hover and click CapsandHat
	@FindBy(xpath = "(//a[text()='caps and hats'])[1]")
	private WebElement capsAndHat;
	public WebElement getCapsAndHat() {
		return capsAndHat;
	}
	
	//Scroll and find this element
	@FindBy(xpath = "//img[@src='//img3.junaroad.com/uiproducts/20113770/zoom_0-1690480893.jpg']")
	private WebElement brownBeanieCap;
	public WebElement getBrownBeanieCap() {
		return brownBeanieCap;
	}
	
	
	//add to cart
	@FindBy(xpath = "//div[text()='ADD TO CART']")
	private WebElement addToCart;
	public WebElement getAddToCart() {
		return addToCart;
	}
	
	
}
