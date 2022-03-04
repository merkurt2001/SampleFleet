package com.translantik.step_definitions;

import com.translantik.pages.GeneralInformationPage;
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
    GeneralInformationPage genInfoPage = new GeneralInformationPage();
    String deletedCarInfo;

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

    @When("the user clicks on a row whose {string} equals {string}")
    public void theUserClicksOnARowWhoseEquals(String columnName, String value) {
        deletedCarInfo = value;
        vehiclesPage.selectPerPage(100);
        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.selectRowWithAny(columnName,value).click();
        vehiclesPage.waitUntilLoaderScreenDisappear();
    }

    @And("the user clicks on the delete button and Yes,Delete confirmation button on the General Information page")
    public void theUserClicksOnTheDeleteButtonAndYesDeleteConfirmationButtonOnTheGeneralInformationPage() {
        genInfoPage.waitUntilLoaderScreenDisappear();
        genInfoPage.deleteButton.click();
        genInfoPage.yesDeleteButton.click();
        genInfoPage.waitUntilLoaderScreenDisappear();
    }

    @Then("the car is deleted and the {string} message should be displayed")
    public void theCarIsDeletedAndTheMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = genInfoPage.carDeletedMessage.getText();
        Assert.assertEquals("Message is NOT as expected",expectedMessage,actualMessage);
    }
}
