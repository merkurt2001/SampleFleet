package com.translantik.step_definitions;

import com.translantik.pages.LoginPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteCarStepDefinitions {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @When("the user hovers over the three dots of row whose {string} equals {string}")
    public void theUserHoversOverTheThreeDotsOfRowWhoseEquals(String columnName, String value) {
        vehiclesPage.goThreeDot(columnName,value);
    }

    @Then("the user should be able to see the delete button")
    public void theUserShouldBeAbleToSeeTheDeleteButton() {
        Assert.assertTrue("the delete button is NOT displayed",vehiclesPage.deleteButton.isDisplayed());
    }

    @And("the user clicks on the delete button")
    public void theUserClicksOnTheDeleteButton() {
        vehiclesPage.deleteButton.click();
        BrowserUtils.waitForVisibility(vehiclesPage.deleteConfirmation,3);
    }

    @Then("The Delete Confirmation pop up should be displayed")
    public void theDeleteConfirmationPopUpShouldBeDisplayed() {
        Assert.assertTrue("Delete Confirmation pop up is NOT displayed ",vehiclesPage.deleteConfirmation.isDisplayed());
    }

    @And("the user clicks on the -Yes,Delete- confirmation button")
    public void theUserClicksOnTheYesDeleteConfirmationButton() {
        BrowserUtils.waitForVisibility(vehiclesPage.deleteConfirmation,5);
        vehiclesPage.yesDeleteButton.click();
    }

    @Then("the user should delete the car and {string} message should be displayed")
    public void theUserShouldDeleteTheCarAndMessageShouldBeDisplayed(String expectedMessage) {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        String actualMessage = vehiclesPage.itemDeletedMessage.getText();
        Assert.assertEquals("Message is NOT as expected",expectedMessage,actualMessage);
    }
}
