package com.cydeo.tests.homeworks;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchFunctionalityTitleVerification {

    //TC#1: Google Search Functionality Title Verification



    //    Note: Follow POM

    GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void setup(){

        //1. User is on Google search page
        Driver.getDriver().get("https://www.google.com/");

        googleSearchPage = new GoogleSearchPage();

    }

    @Test
    public void steve_jobs_is_in_the_google_title_test(){

        //2. User types apple in the google search box and clicks enter
        googleSearchPage.searchBox.sendKeys("apple"+Keys.ENTER);

        //3. User sees Steve Jobs is in the google title
        String expectedTitle = "Steve Jobs";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,(expectedTitle));

        // Expected :Steve Jobs
        //Actual   :apple - Google Search

        // Titles do not match!

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
