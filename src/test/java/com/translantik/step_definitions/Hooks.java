package com.translantik.step_definitions;

import com.translantik.pages.LoginPage;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();
        loginPage.waitUntilLoaderScreenDisappear();
        loginPage.navigateToModule("Fleet","Vehicles");
        loginPage.waitUntilLoaderScreenDisappear();
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }

    @Before ("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After ("@db")
    public void tearDowndb(){
        System.out.println("\tdisconnecting to database...");
    }

}
