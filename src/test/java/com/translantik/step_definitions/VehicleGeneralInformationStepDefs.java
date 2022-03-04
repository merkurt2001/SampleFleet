package com.translantik.step_definitions;

import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VehicleGeneralInformationStepDefs {
    @When("the store manager clicks any row")
    public void the_store_manager_clicks_any_row() {
        new VehiclesPage().selectAnyRowOfAllCarsTable(1);
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String expectedTitle) {
        String actualTitle = new GeneralInformationPage().pageTitle.getText();
        Assert.assertEquals("General Information Page Title", expectedTitle, actualTitle);

    }

    @Then("the store manager clicks any three dot at the end of the row")
    public void theStoreManagerClicksAnyThreeDotAtTheEndOfTheRow() {
        new VehiclesPage().goThreeDot("ChassisNumber", "264,783");
    }


    @When("the store manager clicks on the Eye {string} icon")
    public void theStoreManagerClicksOnTheEyeIcon(String iconName) {
        new VehiclesPage().getThreeDotIcon(iconName).click();
    }


}
