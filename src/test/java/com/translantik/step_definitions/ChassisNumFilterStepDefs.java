package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ChassisNumFilterStepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @When("the user clicks on Chassis Number checkbox")
    public void the_user_clicks_on_Chassis_Number_checkbox() {
        BrowserUtils.waitForClickablility(vehiclesPage.chassisNumberBox,10);
        vehiclesPage.chassisNumberBox.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the Chassis Number checkbox should be selected")
    public void theChassisNumberCheckboxShouldBeSelected() {
        Assert.assertTrue(vehiclesPage.chassisNumberBox.isSelected());
    }

    @And("the user clicks on Chassis Number All button")
    public void theUserClicksOnChassisNumberAllButton() {
        BrowserUtils.waitForClickablility(vehiclesPage.chassisNumberAllButton,10);
        vehiclesPage.chassisNumberAllButton.click();
        BrowserUtils.waitFor(1);
    }

    @And("the user clicks on dropdown menu")
    public void theUserClicksOnDropdownMenu() {
        BrowserUtils.waitFor(3);
        vehiclesPage.chassisDropdownMenu.click();
        System.out.println("clicked on the chassisDropdownMenu button ");
        BrowserUtils.waitFor(2);
    }

    @Then("Chassis Number\" filter should provide the methods shown as below")
    public void chassisNumberFilterShouldProvideTheMethodsShownAsBelow(List<String> menuOptions) throws Throwable {
        BrowserUtils.waitFor(3);
//        List<String> actualChassisOptions = BrowserUtils.getElementsText(new VehiclesPage().chassisDDMenuOpts);
        List<String> actualChassisOptions = BrowserUtils.getElementsText(new VehiclesPage().chassisDDMenuOpts);

        System.out.println("actualChassisOptions = " + actualChassisOptions);
        System.out.println("actualChassisOptions.size() = " + actualChassisOptions.size());
        System.out.println("actualChassisOptions.get(1) = " + actualChassisOptions.get(1));
        System.out.println("menuOptions = " + menuOptions);

        Assert.assertEquals(null,menuOptions,actualChassisOptions);

    }

    @And("the user clicks More Than button")
    public void theUserClicksMoreThanButton() {
        vehiclesPage.moreThanButton.click();
    }

    @And("enter numeric values")
    public void enterNumericValues() {
        vehiclesPage.inputBox.sendKeys(ConfigurationReader.get("moreThanChassisNumber"));
        BrowserUtils.waitFor(1);
    }

    @And("click update button")
    public void clickUpdateButton() {
        vehiclesPage.updateButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the results should be more than specified value")
    public void theResultsShouldBeMoreThanSpecifiedValue() {

        List<String> chassisNumResList = BrowserUtils.getElementsText(vehiclesPage.chassisNumResults);

        System.out.println("chassisNumResList.size() = " + chassisNumResList.size());
        System.out.println("chassisNumResList = " + chassisNumResList);

        BrowserUtils.waitForClickablility(vehiclesPage.forwardPageArrow,10);

        if(ExpectedConditions.elementToBeClickable(vehiclesPage.forwardPageArrow)==vehiclesPage.forwardPageArrow) {
            System.out.println("forward paga arrow is clickable");
        }else{
                System.out.println("forward page arrow is NOT clickable");
            };

        };

    }
