package com.step_definition_classes;

import java.io.IOException;
import com.cucumber_base_class.LimeRoad_BaseClass;
import com.cucumber_pom_class.Mens_CapsAndHat_Pom2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LimeRoad_Step_definition extends LimeRoad_BaseClass {
	
	//LogIn_Page_PomClass1 lpom = new LogIn_Page_PomClass1(driver);	
	
	
	Mens_CapsAndHat_Pom2 capAndHat = new Mens_CapsAndHat_Pom2();	
	
	@When("launch the url {string}")
	public void launch_the_url(String str) {	
		launchURL(str);		
	}	
		
	@And("To click on shop men")
	public void to_click_on_shop_men() throws InterruptedException {
		
		clickElement(capAndHat.getShopMen());
		Thread.sleep(3000);
	}
	
	@And("Redirect to Page inside")
	public void redirectTo(){
		redirectTo("https://www.limeroad.com/men-clothing?src_id=navdeskMen__1");
	}
 
	@And("Hover on Mens Tab")
	public void hover_on_mens_tab() throws InterruptedException {
		
		mouseHoverElement(capAndHat.getMenTab());
			
	}

	@And("Click on CapsAndHats")
	public void click_on_caps_and_hats() throws InterruptedException {
		
		waitForElementToBeVisible(capAndHat.getCapsAndHat());
		clickElement(capAndHat.getCapsAndHat());
		//waitForElementToBeClicked(capAndHat.getCapsAndHat());
	}

	
	@And("Scroll and click on unisex beanie cap")
	public void search_and_click_on() throws InterruptedException {
		
		Thread.sleep(5000);
		scrollDown(capAndHat.getBrownBeanieCap());
		implicitWait(20);
		clickElement(capAndHat.getBrownBeanieCap());
		
	}

	@And("Add To Cart")
	public void add_to_cart() throws InterruptedException {
		Thread.sleep(5000);
		clickElement(capAndHat.getAddToCart());
		Thread.sleep(5000);
		try {
			takeScreenShot("ElementInCart");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@And("close the browser")
	public void close_the_browser() {
		quitBrowser();
	}

}
