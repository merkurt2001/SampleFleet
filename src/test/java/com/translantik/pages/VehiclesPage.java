package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPageButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']" +
            "//li[@class='launcher-item'][3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal oro-modal-danger in']")
    public WebElement deleteConfirmation;

    @FindBy(css = ".btn.cancel")
    public WebElement cancelButton;

    @FindBy(css = ".btn.ok.btn-danger")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']")
    public WebElement itemDeletedMessage;

    public void selectAnyRowOfAllCarsTable(int rowNum1to25) {
    BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")),10);
    Driver.get().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")).click();
    }

    public WebElement selectRowWithAny(String head, String value){
        String xpath = "//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-"+head+"'][.='"+value+"']";
        return Driver.get().findElement(By.xpath(xpath));
    }


    /**
     * This method will click on three dot of a row depend on specific head and value param in translantik application.
     * For example: if head is equals to ChassisNumber, and value equals to 123,325,
     * Then method will click on the three dot of the row whose ChassisNumber value equals 123,325
     *
     * @param head
     * @param value
     */
    public void goThreeDot(String head,String value){
        selectPerPage(100);
        String xpath = "//td[contains(@class,'-cell grid-cell grid-body-cell grid-body-cell-"+head+"')][.='"+value+"']/..//a/..";
        WebElement element = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(element,5);
        new Actions(Driver.get()).moveToElement(element).pause(2000).doubleClick(element).build().perform();
    }

    public void selectPerPage(int dataSize){
        viewPerPageButton.click();
        Driver.get().findElement(By.xpath("//a[@data-size='" + dataSize + "']")).click();
    }
}