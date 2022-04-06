package com.contacts247pro.pages;

import com.contacts247pro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy (css="[formcontrolname='email']")
    public WebElement emailInput;

    @FindBy (css = "[type='password']")
    public WebElement passwordInput;

    @FindBy (css = ".submit-button")
    public WebElement loginButton;

    @FindBy (xpath = "//span[contains(@class,'h1 ng-tns')]")
    public WebElement welcomeMessage;

    @FindBy (xpath="//b[@class='ml-4']")
    public WebElement activeUserLabel;

}
