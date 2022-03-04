package com.translantik.pages;

import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GeneralInformationPage extends BasePage {

    @FindBy(xpath = "//h5/span")
    public WebElement pageTitle;
    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;
    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    public List<String> getAllInfo() {
        List<String> info = new ArrayList<>();
        info.add("");
        for (int i = 1; i <20; i++) {
            info.add(Driver.get().findElement(By.xpath("(//div[@class='responsive-cell responsive-cell-no-blocks']//div[@class='control-label'])["+i+"]")).getText());
        }
        info.add("...");
        return info;
    }
}
