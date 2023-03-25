package com.login_functionality.step_definitions;

import com.login_functionality.pages.TranslantikWebPage;
import com.login_functionality.utilities.BrowserUtils;
import com.login_functionality.utilities.ConfigurationReader;
import com.login_functionality.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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


    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String arg0) {
        Assert.assertTrue(translantikWebPage.popUpMessage(arg0));
    }

    @When("user clicks on the {string} link")
    public void userClicksOnTheLink(String arg0) {
        translantikWebPage.forgotPasswordLink.click();
    }


    @Then("user should land on {string} page")
    public void userShouldLandOnPage(String arg0) {
        Assert.assertEquals(Driver.getDriver().getTitle(),arg0);
    }


    @When("user clicks on the {string} button")
    public void userClicksOnTheButton(String arg0) {
        translantikWebPage.rememberMeButton.click();
        translantikWebPage.rememberMeButton.isEnabled();
    }

    @When("user types password {string}")
    public void userTypesPassword(String arg0) {
        translantikWebPage.passwordField.sendKeys(arg0);
    }


    @Then("user should see the password in bullet signs")
    public void userShouldSeeThePasswordInBulletSigns() {
        BrowserUtils.sleep(1);
        Assert.assertEquals(translantikWebPage.isBulletSign(), "password");
}

    @When("user types username {string} and clicks enter")
    public void userTypesUsernameAndClicksEnter(String arg0) {
        translantikWebPage.usernameField.sendKeys(arg0  + Keys.ENTER);
    }


    @And("user types {string} and clicks enter")
    public void userTypesAndClicksEnter(String arg0) {
        translantikWebPage.passwordField.sendKeys(arg0 + Keys.ENTER);
    }

    @Then("user should see their own usernames in the profile")
    public void userShouldSeeTheirOwnUsernamesInTheProfile() {
        Assert.assertEquals(translantikWebPage.profileMenu(),"user1");
    }
}
