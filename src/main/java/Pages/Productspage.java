package Pages;



import org.openqa.selenium.By;


public class Productspage extends Basepage {
	
	public Productspage() {
		super();
		
	}

		//private By cartbutton = By.xpath("//button[contains(text(), 'Add to cart')]");
		private By cartbeforeaddition = By.xpath("//a[@class='shopping_cart_link']");
		private By cartafteraddition = By.xpath("//span[@class='shopping_cart_badge']");
		// Returns a dynamic locator based on the product name
		
		
		private By getAddToCartButton(String productName) {
		    return By.xpath("//div[contains(@class,'inventory_item') and .//div[contains(text(),'" 
		            + productName + "')]]//button[contains(text(),'Add to cart')]");
		}
			
		public void clickCartIcon() {
		    click(cartafteraddition); 
		}
		public boolean isCartEmpty() {
			 return isDisplayed(cartbeforeaddition);
		}
		
		public void addProductToCartIfExists(String productName) {

		    if(driver.findElements(getAddToCartButton(productName)).size() > 0) {
		        click(getAddToCartButton(productName));
		        System.out.println("Added: " + productName);
		    } 
		    else {
		        System.out.println("Product not found: " + productName);
		    }
		}
		
		public String checkProductsAddedToCart() {
			return getText(cartafteraddition);
		}
}
 