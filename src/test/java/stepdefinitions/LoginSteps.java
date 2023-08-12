package stepdefinitions;

import com.narinderpal.singh.driver.DriverInitializer;
import com.narinderpal.singh.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginpage = new LoginPage(DriverInitializer.getDriver());
	
@Given("user is on the website")
public void user_is_on_the_website() {
    DriverInitializer
    .getDriver()
    .get("https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login&hubs_content=www.hubspot.com/&hubs_content-cta=homepage-nav-login");
}

@Given("user clicks on the login button")
public void user_clicks_on_the_login_button() {
	loginpage.acceptcookies();
	
}

@When("user enters valid {string} and {string}")
public void user_enters_valid_and(String Username, String Password) {
	loginpage.loginToAccount(Username, Password);
}

@When("clicks log in")
public void clicks_log_in() {
}

@Then("user should be able to login to the account")
public void user_should_be_able_to_login_to_the_account() {
    
}

@Then("verify the username is correct")
public void verify_the_username_is_correct() {
   
}

}
