package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class VehicleTableArrangements_StepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();


    @Then("the View per page should be {string} default")
    public void theViewPerPageShouldBeDefault(String expected) {
        BrowserUtils.waitFor(5);

//        String actual = Driver.get().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();

        String actual = vehiclesPage.viewPerPageButton.getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

        Assert.assertEquals(expected, actual);
    }

    @Then("options should be same with below")
    public void options_should_be_same_with_below(List<String> expectedOptions) {

        BrowserUtils.waitFor(1);

        List<String> actualList = BrowserUtils.getElementsText(vehiclesPage.viewfilter);
        Assert.assertEquals(expectedOptions, actualList);

        System.out.println("expectedList = " + expectedOptions);
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(expectedOptions, actualList);
    }

    @When("the user click on View per page button")
    public void theUserClickOnButton() {
        vehiclesPage.viewPerPageButton.click();
    }

    @When("the user clicks on {int} to arrange the row numbers of the results")
    public void the_user_clicks_on_to_arrange_the_row_numbers_of_the_results(Integer int1) {
        WebElement viewPerPageOptions = Driver.get().findElement(By.xpath("//a[normalize-space()='" + int1 + "']"));
        viewPerPageOptions.click();
    }

    @Then("the rows should be equal or less than the {int}")
    public void theRowsShouldBeEqualOrLessThanTheValue(int expected) {
        BrowserUtils.waitFor(3);
        System.out.println("actual=" + getNumberOfRows(expected));
        System.out.println("expected=" + expected);

        Assert.assertEquals(expected, getNumberOfRows(expected));
    }

    public int getNumberOfRows(int a) {
        List<String> allRowsWithoutHeader = BrowserUtils.getElementsText(vehiclesPage.vehicleTableRows);
        return allRowsWithoutHeader.size();
    }


    @When("the user click the Model Year button")
    public void the_user_click_the_Model_Year_button() {
        BrowserUtils.waitFor(3);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click();", vehiclesPage.modelYearLocator);


    }

    @Then("the user can sort a column in ascending or descending order")
    public void the_user_can_sort_a_column_in_ascending_or_descending_order() {

    }

    @Then("the user click the reset button")
    public void the_user_click_the_reset_button() {
        BrowserUtils.waitFor(3);
        vehiclesPage.resetButton_Locator.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the user can remove all sortings and filterings on the page")
    public void the_user_can_remove_all_sortings_and_filterings_on_the_page() {
        for (WebElement a : vehiclesPage.spanCaret_Locator) {
            Assert.assertFalse(a.isDisplayed());
        }
    }
}



