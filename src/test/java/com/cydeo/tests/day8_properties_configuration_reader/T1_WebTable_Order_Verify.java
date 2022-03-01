package com.cydeo.tests.day8_properties_configuration_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //TC #1: Web table practice
        //1. Go to: https://practice.cydeo.com/web-tables
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name(){

        //Locate the cell that has Bob Martin text in it
        WebElement bobMartinCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[.='Bob Martin']"));

        //2. Verify Bob’s name is listed as expected.
        // Expected: “Bob Martin”

        String expectedBobsName = "Bob Martin";
        String actualBobsName = bobMartinCell.getText();

        Assert.assertEquals(actualBobsName, expectedBobsName);

        //Locate the cell that has Bob Martin text in it
        WebElement bobMartinsOrderDateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[.='Bob Martin']/following-sibling::td[3]"));

        // 3. Verify Bob Martin’s order date is as expected
        // Expected: 12/31/2021

        String expectedBobsOrderDate = "12/31/2021";
        String actualBobsOrderDate = bobMartinsOrderDateCell.getText();

        Assert.assertEquals(actualBobsName, expectedBobsName);

        // Print out all Names from the table

        List<WebElement> allNamesFromTheTable = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement webElement : allNamesFromTheTable) {
            System.out.println(webElement.getText());
        }


    }

    // Using utility method to find the customer's order date
    @Test
    public void test2(){

        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Bob Martin");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);
        
    }

    // Using utility method to verify actual customer's order date with expected
    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");
    }

}
