package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_task5(){

        //TC #5: Selecting state from State dropdown and verifying result

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        //Use all Select options. (visible text, value, index)
        stateDropdown.selectByVisibleText("Illinois");


        //4. Select Virginia
        //Use all Select options. (visible text, value, index)
        stateDropdown.selectByValue("VA");

        //5. Select California
        //Use all Select options. (visible text, value, index)
        stateDropdown.selectByIndex(5);


        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionalText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionalText, expectedOptionText);

        driver.close();
    }

    @Test
    public void dropdown_task6(){

        //TC #6: Selecting date on dropdown and verifying

        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDateOfBirthDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDateOfBirthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDateOfBirthDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //   Select year using  : visible text
        yearDateOfBirthDropdown.selectByVisibleText("1923");

        //   Select month using   : value attribute
        monthDateOfBirthDropdown.selectByValue("11");

        //   Select day using : index number
        dayDateOfBirthDropdown.selectByIndex(0);

        // creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDateOfBirthDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDateOfBirthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDateOfBirthDropdown.getFirstSelectedOption().getText();


        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

        driver.close();

    }




}

