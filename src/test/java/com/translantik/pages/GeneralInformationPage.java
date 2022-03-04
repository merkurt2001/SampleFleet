package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;
    @FindBy(xpath = "//h5/span")
    public WebElement pageTitle;
}
