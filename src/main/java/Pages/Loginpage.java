package Pages;

import org.openqa.selenium.By;

public class Loginpage extends Basepage {

    public Loginpage() {
		super(); //java automatically calls parent constructor if no parameters are passed
		
	}


   private By usernameInput = By.xpath("//input[contains(@id,'user-name')]");
   private By passwordInput = By.xpath("//input[contains(@id,'password')]");
   private By loginButton = By.xpath("//input[contains(@name,'login-button')]");
   private By errorMessage = By.xpath("//div[@class=\"error-message-container error\"]/h3");
   private By loginpagetitle = By.xpath("//div[contains(text(),'Swag Labs')]");
   private By homepagetitle = By.xpath("//*[contains(text(),'Products')]");

    // Now using BasePage methods
   public String getLoginPageTitle() {
       return getText(loginpagetitle);
   }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public String getHomePageTitle() {
        return getText(homepagetitle);
    }

 //   public void login(String username, String password) {
//        enterUsername(username);
//        enterPassword(password);
    public void login() {
        clickLogin();
    }
}