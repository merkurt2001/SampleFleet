package com.translantik.step_definitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;


public class LogOutStepDefs {

    @Given("Store Manager click  userNameDropDown")
    public void storeManagerClickuserNameDropDown() {
        new VehiclesPage().userNameDropDown.click();

    }

    @Given("click the Logout")
    public void click_the_Logout() {
        new VehiclesPage().logOutLink.click();


    }

    @Then("The Store Manager should be on the Login Page")
    public void the_Store_Manager_should_be_on_the_Login_Page() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Login",actualTitle);


    }

    @And("The Store Manager click the step back button")
    public void theStoreManagerClickTheStepBackButton() {
        Driver.get().navigate().back();


    }

    @Then("The Store Manager Should be still on the login page")
    public void theStoreManagerSholdBeStillOnTheLoginPage() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Login",actualTitle);


    }

    @Given("Store Manager doesn't do any keybord and mouse action for {int} minutes")
    public void storeManagerDoesnTDoAnyKeybordAndMouseActionForMinutes(int arg0)
            throws InterruptedException {
        Thread.sleep(185000);

    }

    @Given("Store Manager close the tab and open a new page and goes to {string}")
    public void storeManagerCloseTheTabAndOpenANewPageAndGoesTo(String link) throws InterruptedException {
        Driver.get().quit();
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(link);

    }
    WebDriver driver;
    @Then("The Store Manager should be on the new Login Page")
    public void theStoreManagerShouldBeOnTheNewLoginPage() {
        driver.getTitle();
        Assert.assertEquals("Login",driver.getTitle());
        driver.quit();
    }
}