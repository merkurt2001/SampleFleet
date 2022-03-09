package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage {

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement lastPageNum;

    @FindBy(css = "i[class='fa-chevron-right hide-text']")
    public WebElement forwardPageArrow;

    @FindBy(xpath = "//input[@value='ChassisNumber']")
    public WebElement chassisNumberBox;

    @FindBy(xpath = "//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")
    public WebElement chassisNumberAllButton;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement chassisDropdownMenu;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[5]")
    public List<WebElement> chassisDDMenuOptions;

    @FindBy(css = "a.dropdown-item.choice-value")
    public List<WebElement> chassisDDMenuOpts;

    @FindBys({@FindBy(xpath = "//a[@class='dropdown-item choice-value']")})
    public List<WebElement> chassisDropdownMenuElements;

    @FindBy (css = "a[data-value='2']")
    public WebElement moreThanButton;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement inputBox;

    @FindBy(css = "button[class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy (css = "[data-column-label='Chassis Number']")
    public List<WebElement> chassisNumResults;

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

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecordsText;

    public String getTotalRecords(){
        String[] arr = totalRecordsText.getText().split(" ");
        return arr[2];
    }

    public void selectAnyRowOfAllCarsTable(int rowNum1to25) {
    BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")),10);
    Driver.get().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNum1to25+"]")).click();
    }

    public WebElement selectRowWithAny(String head, String value){
        String xpath = "//td[contains(@class,'-cell grid-cell grid-body-cell grid-body-cell-"+head+"')][.='"+value+"']";
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
        String xpath = "//td[contains(@class,'-cell grid-cell grid-body-cell grid-body-cell-"+head+"')][.='"+value+"']/..//a/..";
        WebElement element = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(element,5);
        new Actions(Driver.get()).moveToElement(element).pause(2000).doubleClick(element).build().perform();
    }

    public void selectPerPage(int dataSize){
        viewPerPageButton.click();
        Driver.get().findElement(By.xpath("//a[@data-size='" + dataSize + "']")).click();
    }
    public WebElement getThreeDotIcon(String iconName){
        return Driver.get().findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//a[@title='"+iconName+"']"));
    }

    public List<String> getAllInfoOfRow(int rowNumber) {
        List<WebElement> getAllInfo = new ArrayList<>();
        for (int i = 2; i < 21; i++) {
            getAllInfo.add(Driver.get().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+rowNumber+"]//td["+i+"]")));
        }
        List<String> elementsText = BrowserUtils.getElementsText(getAllInfo);
        String noComma4 = elementsText.get(4).replaceAll(",","");
        elementsText.set(4,noComma4);
        String noComma6 = elementsText.get(6).replaceAll(",","");
        elementsText.set(6,noComma6);

        return elementsText;
    }

    public boolean isClickable(WebElement webe)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}