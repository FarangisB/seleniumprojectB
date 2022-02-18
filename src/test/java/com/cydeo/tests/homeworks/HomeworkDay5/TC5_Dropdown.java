package com.cydeo.tests.homeworks.HomeworkDay5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC5_Dropdown {

    WebDriver driver;

    //TC #5: Selecting state from State dropdown and verifying result

    @BeforeMethod
    public  void  browserSetup(){

        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        System.out.println();
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void selectState() throws InterruptedException {

        //3. Select Illinois
        //4. Select Virginia
        //5. Select California
        Select selectStatesDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        List<WebElement> allStates = selectStatesDropdown.getOptions();

        selectStatesDropdown.selectByVisibleText("Illinois");
        Thread.sleep(2000);

        selectStatesDropdown.selectByValue("VA");
        Thread.sleep(2000);

        selectStatesDropdown.selectByIndex(5);
        Thread.sleep(2000);

        //6. Verify final selected option is California.

        String actualFinalSelectedStateText = selectStatesDropdown.getFirstSelectedOption().getText();
        String expectedFinalSelectedStateText = "California";

        Assert.assertEquals(actualFinalSelectedStateText, expectedFinalSelectedStateText, "The final selected option is not as expected");

      //  WebElement finalSelectedState = driver.findElement(By.xpath("//option[@value='CA']"));
      //  System.out.println("Final Selected State is = " + finalSelectedState.getText());


    }




    //Use all Select options. (visible text, value, index)



}
