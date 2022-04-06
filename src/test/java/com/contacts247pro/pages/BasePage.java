package com.contacts247pro.pages;

import com.contacts247pro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public abstract class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.get(), this);

    }
    @FindBy (tagName = "mat-spinner")
    public WebElement matSpinner;

    @FindBy (xpath = "//mat-table//mat-row")
    public List<WebElement> rowsOfTable;


    public WebElement getTabNameUnderMenu(String tab){
        return Driver.get().findElement(By.xpath("//span[text()='"+tab+"']"));
    }

    public WebElement getContactModulWithText(String tab){
        if (tab.equals("All")) {
            return Driver.get().findElement(By.xpath("//span[.='"+tab+"']"));
        }else
        return Driver.get().findElement(By.xpath("//div[.='"+tab+"']"));
    }

    public WebElement getSelectionWithText(String text){
        return Driver.get().findElement(By.xpath("//div[@class='cdk-overlay-pane']//button//div[text()='"+text+"']"));
    }
    public WebElement getButtonWithOnDialog(String button){
        return Driver.get().findElement(By.xpath("//button/span[.='"+button+"']"));
    }
    public WebElement getDialogTitle(String heading){
        return Driver.get().findElement(By.xpath("//div[.='"+heading+"']"));
    }
    public WebElement getTextFieldWithLabel(String label){
        return Driver.get().findElement(By.xpath("//input[@data-placeholder='"+label+"']"));
    }
}
