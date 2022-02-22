package com.cydeo.tests.homeworks.homeworkDay6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_iframePractice {

    //TC #4: Iframe practice

    WebDriver driver;



    @BeforeMethod
    public void setupDriver(){
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void verifying_YourContentGoesHere_isDisplayed(){
    //4. Assert: “Your content goes here.” Text is displayed.

        driver.switchTo().frame(0);

        WebElement yourContentGoesHere = driver.findElement(By.xpath("//p"));

        System.out.println("Text is = " + yourContentGoesHere.getText());

        Assert.assertTrue(yourContentGoesHere.isDisplayed());

    driver.switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        WebElement aniFrameContainingTheTinyMCEWYSIWYGEditor = driver.findElement(By.xpath("//h3"));

        System.out.println("Text is = " + aniFrameContainingTheTinyMCEWYSIWYGEditor.getText());

        Assert.assertTrue(aniFrameContainingTheTinyMCEWYSIWYGEditor.isDisplayed());




    }






}
