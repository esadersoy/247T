package com.contacts247pro.pages;

import com.contacts247pro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class ContactsPage extends BasePage{


    @FindBy (xpath="//button[@class='mat-focus-indicator mat-tooltip-trigger mat-menu-trigger application-button mat-button mat-button-base']")
    public WebElement menuButton;

    @FindBy (xpath ="//div[.='account_circleContacts']")
    public WebElement contactsButton;

    @FindBy (xpath = "//*[text()='Contacts']")
    public WebElement contactsHeadline;

    @FindBy (xpath = "//span[contains(.,'New Contact')]")
    public WebElement addContactButton;

    @FindBy (xpath ="//div[.='Create Contact']")
    public WebElement createHeadline;

    @FindBy (css = "mat-icon:nth-of-type(2)")
    public WebElement contactTypeDropdown;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement contactNameInput;

    @FindBy (xpath ="//input[@name='company']")
    public WebElement companyNameInput;

    @FindBy (xpath ="//input[@name='title']")
    public WebElement contactTitleInput;

    @FindBy (css ="[pattern='[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,24}$']")
    public WebElement emailInput;

    @FindBy (css =" [type='text']")
    public WebElement phoneInput;

    @FindBy (xpath ="//span[.='Save']")
    public WebElement saveContactButton;

    @FindBy (css = ".mat-menu-content > button:nth-of-type(1)")
    public WebElement editDialog;

    @FindBy (xpath = "//div[contains(@class,'title')]/div")
    public WebElement editHeadline;


    @FindBy (css = ".mat-menu-content > button:nth-of-type(2)")
    public WebElement deleteDialog;

    @FindBy (css = "mat-row:nth-of-type(1) .mat-menu-trigger")
    public WebElement threeDotsDialogButton;

    @FindBy (xpath = "//div[.='Confirm']")
    public WebElement deleteConfirmationHeadline;

    @FindBy (xpath = "//span[.='Confirm']")
    public WebElement confirmButton;

    @FindBy (xpath = "//mat-table//b")
    public List<WebElement> nameColumnElements;

    @FindBy (xpath = "//mat-table//p")
    public List<WebElement> emailColumnElements;

    @FindBy (xpath = "//mat-table//mat-cell[contains(@class,'phone')]//span")
    public List<WebElement> phoneColumnElements;

    @FindBy (xpath = "//mat-table//mat-cell[contains(@class,'company')]//span")
    public List<WebElement> companyColumnElements;

    @FindBy (xpath = "//mat-table//mat-icon[contains(@class,'mat-icon')]")
    public List<WebElement> threeDotsColumnElements;


}
