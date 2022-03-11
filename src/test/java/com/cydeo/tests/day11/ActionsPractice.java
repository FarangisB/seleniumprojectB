package com.cydeo.tests.day11;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void task4_and_5_test() {
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //Create object of actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).pause(2).perform();

        //5 - Scroll back up to "Home" link using PageUp button
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
        }

        Driver.closeDriver();
    }


    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://practice.cydeo.com/");
    }

    @Test
    public void test4(){
        Driver.getDriver().get("https://practice.cydeo.com/");
    }

}
