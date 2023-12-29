
Feature: limeroad order 

  @loginTest
  Scenario: To click on shop men
  Given launch the url "https://www.limeroad.com/"
  And To click on shop men
 
  @MenTab 
  Scenario: To select a hat and place to cart
  Given launch the url "https://www.limeroad.com/"
  And To click on shop men
  And Hover on Mens Tab
  And Click on CapsAndHats
 	And Scroll and click on unisex beanie cap
  And Add To Cart
  And close the browser