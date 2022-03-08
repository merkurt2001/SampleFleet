package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalRecordsText;

    @FindBy (xpath = "//b")
    public WebElement filterCriteriaSelector; //her filtre seçildiğinde çıkan yanında All yazan filtre (Selçuk)

    //filtrede çıkan metod isimleri (Selçuk)
    @FindBy(css = ".dropdown-item.choice-value")
    public List<WebElement> methods;

    //her filtrede default olarak çıkan metod(Selçuk)
    public WebElement defaultMethodOfTheFilter(String name){
        return Driver.get().findElement(By.xpath("//button[contains(text(),'"+name+"')]"));
    }

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
}