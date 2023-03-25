package com.login_functionality.pages;

import com.login_functionality.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranslantikWebPage {

    public TranslantikWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeButton;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    public WebElement profile;

    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logoutButton;

    public boolean popUpMessage(String message) {
        boolean flag = false;
        if (usernameField.getText().equals("")){
            if(usernameField.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(passwordField.getText().equals("")){
            if(passwordField.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        return flag;
    }

    public String isBulletSign(){
        return passwordField.getAttribute("type");
    }

    public String profileMenu(){
        return profile.getAttribute("innerText\n");
    }





}
