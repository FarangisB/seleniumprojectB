package com.cydeo.tests.homeworks;

import com.cydeo.pages.WikiHomePage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaSearchFunctionalityTitleVerification {

    WikiHomePage wikiHomePage;

    @BeforeMethod
    public void setup(){

        wikiHomePage = new WikiHomePage();

    }

    @Test
    public void title_verification_test(){
        //TC#2: Wikipedia Search Functionality Title Verification

        wikiHomePage.go_to_homepage_print_steve_jobs_and_click_search();

        //4. User sees Steve Jobs is in the wiki title
        String expectedPartialTitle = "Steve Jobs";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedPartialTitle));

    }

    @Test
    public void main_header_verification_test(){
        // TC#3: Wikipedia Search Functionality Header Verification
        //1. User is on Wikipedia home page
        //2. User types Steve Jobs in the wiki search box
        //3. User clicks wiki search button
        wikiHomePage.go_to_homepage_print_steve_jobs_and_click_search();

        //4. User sees Steve Jobs is in the main header
        String expectedMainHeaderText = "Steve Jobs";
        String actualMainHeaderText = wikiHomePage.mainHeader.getText();

        Assert.assertEquals(actualMainHeaderText, expectedMainHeaderText);

    }

    @Test
    public void verify_image_header_text(){
        //    TC#4: Wikipedia Search Functionality Image Header Verification
        //1. User is on Wikipedia home page
        //2. User types Steve Jobs in the wiki search box
        //3. User clicks wiki search button
        wikiHomePage.go_to_homepage_print_steve_jobs_and_click_search();

        //4. User sees Steve Jobs is in the image header
        String expectedMainHeaderText = "Steve Jobs";
        String actualMainHeaderText = wikiHomePage.imageHeader.getText();

        Assert.assertEquals(actualMainHeaderText, expectedMainHeaderText);

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
