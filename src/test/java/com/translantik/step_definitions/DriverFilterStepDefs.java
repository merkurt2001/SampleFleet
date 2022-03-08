package com.translantik.step_definitions;

import com.translantik.pages.BasePage;
import com.translantik.pages.Filters;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DriverFilterStepDefs extends BasePage {
    Filters filters = new Filters();
    VehiclesPage vehiclesPage=new VehiclesPage();

    @When("the user clicks on {string} filter")
    public void theUserClicksOnFilter(String filterName) {
        filters.filterName(filterName).click();

    }

    @Then("the {string} filter should be selected")
    public void theFilterShouldBeSelected(String filterName) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filters.filterName(filterName).isSelected());
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String criteriaAll) {
        vehiclesPage.filterCriteriaSelector.click();
    }

    @When("the user clicks on {string} dropdown")
    public void the_user_clicks_on_dropdown(String defaultMethodOfTheFilter) {
        vehiclesPage.defaultMethodOfTheFilter(defaultMethodOfTheFilter).click();

    }

    @Then("the Methods should be seen as below")
    public void the_Methods_should_be_seen_as_below(List<String> methodNames) {

        List<String> actualMethods = BrowserUtils.getElementsText(vehiclesPage.methods);
        Assert.assertEquals(methodNames,actualMethods);
    }

    @When("the user writes the {string} keyword to Contains method input box and click update button")
    public void the_user_writes_the_keyword_to_method_input_box_and_click_update_button(String keyword) {
            //metod yazılacak
    }

    @Then("the results should contain the {string} keyword")
    public void the_results_should_contain_the_keyword(String string) {
        //metod yazılacak
    }

}