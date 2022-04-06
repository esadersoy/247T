package com.contacts247pro.stepDefs;

import com.contacts247pro.pages.LoginPage;
import com.contacts247pro.utilities.BrowserUtils;
import com.contacts247pro.utilities.ConfigurationReader;
import com.contacts247pro.utilities.Driver;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;


public class LoginStepDefs {

    LoginPage loginPage =new LoginPage();
    Logger logger= LoggerFactory.getLogger(LoginStepDefs.class);
    SoftAssertions softAssertions = new SoftAssertions();
    String username;
    @Given("the user on login page")
    public void theUserOnLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    logger.info("The user is on login page");
    }

    @When("the user enters valid email")
    public void the_user_enters_valid_email() {
       // loginPage.emailInput.sendKeys("esadersoy@gmail.com");
        String username= ConfigurationReader.get("username");
        loginPage.emailInput.sendKeys(username);
        logger.info("The username was entered as --> {}",username);

    }

    @When("the user enters valid password")
    public void the_user_enters_valid_password() {
        String password=ConfigurationReader.get("password");
        loginPage.passwordInput.sendKeys(password);
        logger.info("Password was entered as --> {} ", password);
    }

    @And("the user clicks login button")
    public void the_user_clicks_login_button() throws Exception {
       loginPage.loginButton.click();
       logger.info("Login request was sent.");
    }

    @When("the user navigate {string}")
    public void the_user_navigate(String str) throws Exception {
        String expected = str;
       BrowserUtils.waitForVisibility(loginPage.welcomeMessage,10);
        String currentUrl = Driver.get().getCurrentUrl().toString();
        Assert.assertEquals("Dashboard page was not verified!",expected,currentUrl);
        logger.info("Dashboard page URL was verified.");


    }
    @Then("the user should be able to display welcome message")
    public void the_user_should_be_able_to_display_welcome_message() {
        String expected = "Welcome";
        String actual = loginPage.welcomeMessage.toString();
        softAssertions.assertThat(actual.toLowerCase().contains("welcome"));
        logger.info("Welcome message was verified.");

        softAssertions.assertAll();
    }

    @Then("the name of the user should be displayed on the page")
    public void theNameOfTheUserShouldBeDisplayedOnThePage() {
        String expectedUser = ConfigurationReader.get("user");
        String actualUser = loginPage.activeUserLabel.getText();
        softAssertions.assertThat(actualUser).as("Current and expected users are different!").isEqualTo(expectedUser);
        logger.info("Name of user verified as --> {}", expectedUser);
        softAssertions.assertAll();
    }
}
