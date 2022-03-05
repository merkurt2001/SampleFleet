package com.translantik.step_definitions;

import com.translantik.pages.BasePage;
import com.translantik.pages.Filters;
import com.translantik.pages.LoginPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterMenuStepDefs extends BasePage {

    Filters filters = new Filters();
    Select select;

    @Then("filter button is hidden")
    public void filter_button_is_hidden() {
        Assert.assertFalse(filters.manageFiltersButton.isDisplayed());
    }

    @When("the user clicks on filter button")
    public void theUserClicksOnFilterButton() {
        filters.filtersButton.click();
    }

    @Then("manage filter button is visible")
    public void manageFilterButtonIsVisible() {
        Assert.assertTrue(filters.manageFiltersButton.isDisplayed());
    }

    @When("the user click on manage filter button")
    public void theUserClickOnManageFilterButton() {
        filters.manageFiltersButton.click();
    }

    @Then("all names under manage filters menu are clickable")
    public void allNamesUnderManageFiltersMenuAreClickable(){
        for (WebElement filterType : filters.filterTypes) {
            Assert.assertTrue(filters.isClickable(filterType));
        }
    }

    @Then("user enters filter name on the filter input box and corresponding name is displayed")
    public void userEntersFilterNameOnTheFilterInputBoxAndCorrespondingNameIsDisplayed() {

        for (WebElement filterType : filters.filterTypes) {
            String name = filterType.getAttribute("title");
            filters.filterInputBox.sendKeys(name);
            BrowserUtils.waitFor(2);
            Assert.assertTrue(filters.filterName(name).isDisplayed());
            filters.filterInputBox.clear();
        }
    }
}
