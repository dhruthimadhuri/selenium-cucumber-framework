package StepDefinitions;

import org.testng.Assert;

import Pages.Loginpage;
import Utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginstepdef {
	 private Loginpage loginpage = new Loginpage();
	

@Given("user is on login page")
public void user_is_on_login_page() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(loginpage.getLoginPageTitle(),"Swag Labs");
	
}

@When("user enters uname and pwd")
public void user_enters_uname_and_pwd() {
    // Write code here that turns the phrase above into concrete actions
    loginpage.enterUsername(ConfigReader.get("username"));
    loginpage.enterPassword(ConfigReader.get("Password"));
}

@And("clicks on login button")
public void clicks_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	loginpage.clickLogin();
}

@Then("user should be logged in successfully")
public void user_should_be_logged_in_successfully() {
    // Write code here that turns the phrase above into concrete actions
   String homepagetitle = loginpage.getHomePageTitle();
   Assert.assertEquals(homepagetitle, "Products");
   
}
}
