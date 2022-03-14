package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class VehicleTableArrangements_StepDefs {

    VehiclesPage vehiclesPage=new VehiclesPage();


    @Then("options should be same with below")
    public void options_should_be_same_with_below (List < String > expectedOptions) {
        BrowserUtils.waitFor(3);
        List<String> actualList = new ArrayList<>();

        List<WebElement> elements = Driver.get().findElements(By.xpath("//a[@class='dropdown-item']"));

        BrowserUtils.waitFor(2);

        for (WebElement element : elements) {
            String innerText = element.getAttribute("innerText");
            String lastText=innerText.trim();
            actualList.add(lastText);
            BrowserUtils.waitFor(1);
        }


        System.out.println("expectedList = " + expectedOptions);
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(expectedOptions,actualList);



    }



    @Then("the View per page should be {string} default")
    public void theViewPerPageShouldBeDefault( String expected) {
        BrowserUtils.waitFor(5);

        String actual = Driver.get().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();

        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

        Assert.assertEquals(expected,actual);
    }
}
