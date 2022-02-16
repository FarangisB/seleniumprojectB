package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_TestNG {

    WebDriver driver;

    //TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values

    @BeforeMethod
    public void setupMethod(){

        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String expectedSimpleDropdownText = "Please select an option";

        WebElement currentSelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualSimpleDropdownText = currentSelectedOption.getText();

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);


        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedStateSelectionText = "Select a State";

        String actualStateSelectionText = stateSelection.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);



    }
    //TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values

    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”
}
