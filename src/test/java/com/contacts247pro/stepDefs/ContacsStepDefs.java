package com.contacts247pro.stepDefs;

import com.contacts247pro.pages.ContactsPage;
import com.contacts247pro.utilities.BrowserUtils;
import com.contacts247pro.utilities.Driver;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ContacsStepDefs {

    ContactsPage contactsPage = new ContactsPage();
    Logger logger = LoggerFactory.getLogger(ContacsStepDefs.class);
    List<String> dummy = new ArrayList<>();
    SoftAssertions softAssertions = new SoftAssertions();
    public String newName;
    public String selectedContact;

    @When("the user clicks menu button")
    public void the_user_clicks_menu_button() {
        contactsPage.menuButton.click();
        logger.info("User clicked on menu button");
    }

    @And("the user clicks {string} from menu")
    public void theUserClicksFromMenu(String tab) {
        contactsPage.getTabNameUnderMenu(tab).click();
        logger.info("User clicked on {} tab", tab);
    }

    @Then("the user should be able to land on {string} page")
    public void theUserShouldBeAbleToLandOnPage(String str) {
        String expectedUrl = "https://app.247pro.com/contacts";
        String expectedHeadline = str;
        Driver.get().manage().window().maximize();
        BrowserUtils.waitFor(2);
        String currentUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals("Contacs page address was not verified!", expectedUrl, currentUrl);
        logger.info("Contacs page URL was verified.");

        String actualHeadline = contactsPage.contactsHeadline.getText();
        Assert.assertEquals("Contacs headline was not verified!", expectedHeadline, actualHeadline);
        logger.info("Contacts page headline was verified.");
    }

    @Given("the user navigates contacts page")
    public void the_user_navigates_contacts_page() {
        contactsPage.menuButton.click();
        contactsPage.contactsButton.click();
        logger.info("Contacts button was clicked from menu");
    }

    @When("the user clicks new contact button")
    public void the_user_clicks_new_contact_button() {
        contactsPage.addContactButton.click();
        logger.info("New Contact button was clicked");
    }

    @Then("the user should be able to display {string}")
    public void the_user_should_be_able_to_display(String str) {
        String expected = str;
        BrowserUtils.waitFor(2);
        String actual = contactsPage.createHeadline.getText();
        Assert.assertEquals("Crate contact menu opening was not verified!.", expected, actual);
        logger.info("Create contact menu opening was verified.");

    }


    @And("the user enters following inputs")
    public void theUserEntersFollowingInputs(Map<String, String> contactInformation) {
        contactsPage.contactTypeDropdown.click();
        logger.info("User clicked button to select contact type");
        String contactType = contactInformation.get("contactType");
        contactsPage.getSelectionWithText(contactType).click();
        logger.info("User selected {} as contact type", contactType);
        String currentName = contactInformation.get("name");
        contactsPage.contactNameInput.sendKeys(currentName);
        logger.info("User entered name as --> {}",currentName);
        String currentCompany = contactInformation.get("Company");
        contactsPage.companyNameInput.sendKeys(currentCompany);
        logger.info("User entered company name as --> {}",currentCompany);
        String currentTitle = contactInformation.get("title");
        contactsPage.contactTitleInput.sendKeys(currentTitle);
        logger.info("User entered title as --> {}",currentTitle);
        String currentMail = contactInformation.get("email");
        contactsPage.emailInput.sendKeys(currentMail);
        logger.info("User entered email as --> {}", currentMail);
        String currentPhone = contactInformation.get("phone");
        contactsPage.phoneInput.sendKeys(currentPhone);
        logger.info("User entered phone number as --> {}",currentPhone);
        dummy.add(currentName.substring(0, 1));
        dummy.add(currentName);
        dummy.add(currentMail);
        dummy.add(currentPhone);
        dummy.add(currentCompany);
        dummy.add(currentTitle);
        newName=currentName;


    }

    @And("the user clicks save button")
    public void theUserClicksSaveButton()  {
        contactsPage.saveContactButton.click();
        BrowserUtils.waitFor(2);
        logger.info("Save button was clicked");
    }

    @When("the user clicks three dots button of selected contact {string}")
    public void the_user_clicks_button_of_selected_contact(String contact) {
        BrowserUtils.waitFor(4);
        selectedContact=contact;
        List<WebElement> nameColumnElements = contactsPage.nameColumnElements;
        List<String> contactNames = BrowserUtils.getElementsText(nameColumnElements);
        int rowNum = -1;
        for (int i = 0; i < contactNames.size(); i++) {
            if (contactNames.get(i).equals(contact)) {
                rowNum = i;
                break;
            }
        }
        contactsPage.threeDotsColumnElements.get(rowNum).click();
        logger.info("User clicked on three dot of contact of --> {}", contact);
    }

    @When("the user clicks {string} button on the dialog")
    public void the_user_clicks_button_on_the_dialog(String button) {
        BrowserUtils.waitFor(1);
        contactsPage.getButtonWithOnDialog(button).click();
        logger.info("User clicked on {} button", button);
    }

    @Then("{string} dialog should be displayed")
    public void dialog_should_be_displayed(String expected) {
             BrowserUtils.waitFor(2);
        String actual = contactsPage.editHeadline.getText();
        softAssertions.assertThat(actual.contains(expected)).as("Dialog headline was not verified!").isTrue();
        logger.info("Dialog headline was verified as --> {}", expected);


    }

    @When("the user changes {string} of contact with {string}")
    public void the_user_changes_of_contact_with(String label, String value) {
        WebElement field = contactsPage.getTextFieldWithLabel(label);
        field.clear();
        field.sendKeys(value);
        logger.info("User changed value of {} with {}", label, value);
        newName = value;


    }

    @Then("the new user name should be displayed on {string} table")
    public void the_new_user_name_should_be_displayed_on_table(String moduleName) {
        contactsPage.getContactModulWithText(moduleName).click();
        BrowserUtils.waitFor(1);
        logger.info("User clicked on {} module", moduleName);
        List<WebElement> nameColumnElements = contactsPage.nameColumnElements;
        List<String> actualContacts = BrowserUtils.getElementsText(nameColumnElements);
        softAssertions.assertThat(actualContacts.contains(newName)).as("New contact name on the table of " + moduleName + " page was not verified!").isTrue();
        softAssertions.assertAll();
        logger.info("Verified that contact is present on the {} table",moduleName);
    }

    @When("the user clicks on {string}  button on the dialog")
    public void theUserClicksOnButtonOnTheDialog(String button) {

        contactsPage.getButtonWithOnDialog(button).click();
        logger.info("User clicked on {} button",button);
    }


    @Then("the new contact should be displayed on the table")
    public void theNewContactShouldBeDisplayedOnTheTable() {
        BrowserUtils.waitFor(2);
        List<WebElement> rowsOfTable = contactsPage.rowsOfTable;
        List<WebElement> nameColumnElements = contactsPage.nameColumnElements;
        List<String> actualContactNames = BrowserUtils.getElementsText(nameColumnElements);
        String expectedName = dummy.get(1);
        boolean isPresent = actualContactNames.contains(expectedName);

        softAssertions.assertThat(isPresent).as("New contact is not present on the table!").isTrue();
        int rowNum = -1;
        if (isPresent) {

            for (int i = 0; i < actualContactNames.size(); i++) {
                if (actualContactNames.get(i).equals(expectedName)) {
                    rowNum = i;
                    break;
                }
            }
        }
        String expectedEmail = dummy.get(2);
        String expectedPhone = dummy.get(3);
        String expectedCompany = dummy.get(4);
        String actualEmail = contactsPage.emailColumnElements.get(rowNum).getText();
        String displayedPhone = contactsPage.phoneColumnElements.get(rowNum).getText();
        String actualPhone = displayedPhone.substring(4, 7) + displayedPhone.substring(9, 12) + displayedPhone.substring(13, 17);

        String actualCompany = contactsPage.companyColumnElements.get(rowNum).getText();
        softAssertions.assertThat(actualEmail).as("Email address is not verified!").isEqualTo(expectedEmail);
        softAssertions.assertThat(actualPhone).as("Phone number is not verified!").isEqualTo(expectedPhone);
        softAssertions.assertThat(actualCompany).as("Company name is not verified!").isEqualTo(expectedCompany);
        softAssertions.assertAll();
        logger.info("Verified that new contact is present on the table");
        //BrowserUtils.waitFor(2);
    }

    @Then("the selected contact {string} should not be displayed on {string} table")
    public void theSelectedContactShouldNotBeDisplayedOnTable(String contact, String moduleName) {
        contactsPage.getContactModulWithText(moduleName).click();
        BrowserUtils.waitFor(1);
        logger.info("User clicked on {} module", moduleName);
        List<WebElement> nameColumnElements = contactsPage.nameColumnElements;
        List<String> actualContacts = BrowserUtils.getElementsText(nameColumnElements);
        softAssertions.assertThat(actualContacts.contains(contact)).as(contact+" on the table of " + moduleName + " page was not verified!").isFalse();
        softAssertions.assertAll();
        logger.info("Verified that contact is not present on the {} table",moduleName);
        BrowserUtils.waitFor(2);
    }
}
