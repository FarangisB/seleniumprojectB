package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicallyLoadedPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CydeoPagePractice {

    //TC#4 : Dynamically Loaded Page Elements 7
    //        1. Go to https://practice.cydeo.com/dynamic_loading/7
    //        2. Wait until title is “Dynamic title”
    //        3. Assert: Message “Done” is displayed.
    //        4. Assert: Image is displayed.
    //        Note: Follow POM


    @Test
    public void verify_done_is_displayed(){
        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        //2. Wait until title is “Dynamic title”
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        DynamicallyLoadedPage practiceCydeoPage=new DynamicallyLoadedPage();

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(practiceCydeoPage.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(practiceCydeoPage.image.isDisplayed());

        //Note: Follow POM

    }

    @Test
    public void dynamic_load_1_test(){
        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //2. Click to start
        dynamicLoad1Page.startButton.click();

        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("somethingwrong");

        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());

        //Note: Follow POM Design Pattern

    }

}
