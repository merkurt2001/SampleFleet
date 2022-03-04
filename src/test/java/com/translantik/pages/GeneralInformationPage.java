package com.translantik.pages;

import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//h5/span")
    public WebElement pageTitle;
    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;
    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;
}
