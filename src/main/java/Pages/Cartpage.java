package Pages;

import org.openqa.selenium.By;

public class Cartpage extends Basepage {
	
	public Cartpage() {
		super();
	}

		private By itemsincart = By.xpath("//div[@class=\"cart_item\"]");
		
		public int itemsInCart() {
			return driver.findElements(itemsincart).size();
		}
}
