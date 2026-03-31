package StepDefinitions;

import java.util.List;

import org.testng.Assert;

import Pages.Cartpage;
import Pages.Loginpage;
import Pages.Productspage;
import Utils.ConfigReader;
import Utils.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Productstepdef {
	Loginpage loginpage = new Loginpage();
	Productspage productpage = new Productspage();
	Cartpage cartpage = new Cartpage();
	
	
	@Given("user is logged in to the application")
	public void user_is_logged_in_to_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	   loginpage.enterUsername(ConfigReader.get("username"));
	   loginpage.enterPassword(ConfigReader.get("Password"));
	   loginpage.clickLogin();
	}

	@When("user select the product")
	public void user_select_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	  if( productpage.isCartEmpty()) {
		  System.out.println("before excel read");
	   List<String> productnames = ExcelUtils.getColumnValues("Products", "productname");

	   for(String productname : productnames) {
	       productpage.addProductToCartIfExists(productname);
	   }	
	  }
	   
	}

	@And("click on add to cart")
	public void click_on_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		 if(productpage.checkProductsAddedToCart().length()>=0) {
			   productpage.clickCartIcon();		   
		   }
	}

	@Then("verify product is successfully added to the cart")
	public void verify_product_is_successfully_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	
	  Assert.assertTrue(cartpage.itemsInCart()>0, "Successfully added");
	}



}
