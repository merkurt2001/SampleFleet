package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends BasePage{

    @FindBy(xpath = "//a[@title='Delete Car']/..")
    public WebElement deleteButton;

    @FindBy(css = ".btn.cancel")
    public WebElement cancelButton;

    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeleteButton;

    @FindBy(css = ".message")
    public WebElement carDeletedMessage;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;
}
