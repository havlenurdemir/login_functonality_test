package com.login_functionality.step_definitions;

import com.login_functionality.pages.TranslantikWebPage;
import com.login_functionality.utilities.ConfigurationReader;
import com.login_functionality.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.util.Map;

public class LoginFunctionality {

    TranslantikWebPage translantikWebPage=new TranslantikWebPage();

    @Given("user is on the translantik page")
    public void user_is_on_the_translantik_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("translantik.url"));
    }
    @When("user is on the translantik web page")
    public void user_is_on_the_translantik_web_page() {

    }
    @When("user enters {string} into username field")
    public void user_enters_user1_into_username_field(String string) {
        translantikWebPage.usernameField.sendKeys(string, Keys.ENTER);
    }
    @When("user enters {string} into password field")
    public void user_enters_user_user123_into_password_field(String string) {
        translantikWebPage.passwordField.sendKeys(string, Keys.ENTER);
    }
    @Then("user should land on the {string} page")
    public void user_should_land_on_the_page(String string) {

    }

    @When("user enters <username> into username field")
    public void user_enters_username_into_username_field(Map<String, String> credentials) {
        translantikWebPage.usernameField.sendKeys(credentials.get("username")+Keys.ENTER);
    }
    @When("user enters <password> into password field")
    public void user_enters_password_into_password_field(Map<String, String> credentials) {
        translantikWebPage.passwordField.sendKeys(credentials.get("password")+Keys.ENTER);
    }



}
