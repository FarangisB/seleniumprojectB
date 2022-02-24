package com.cydeo.tests.homeworks.homeworksByAdam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame_Practice {

    WebDriver driver;

    //TC 1: As a User I should be able to see ‘Your content goes here.’
    // And ‘An iFrame containing the TinyMCE WYSIWYG Editor’

    @BeforeMethod
    public void setupDriver(){
        //1- Open a Chrome browser
        //2- Go to https://the-internet.herokuapp.com/
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void verify_iFrame_Labels(){

        //3- Click iFrame
        WebElement frameLink = driver.findElement(By.xpath("//ul//li[22]/a"));
        frameLink.click();

        WebElement iFrameLink = driver.findElement(By.xpath("//ul//li[2]/a"));
        iFrameLink.click();

        //4- Verify the ‘Your content goes here.’ label
        driver.switchTo().frame(0);
        WebElement labelText = driver.findElement(By.xpath("//p"));
        String expectedLabelText = "Your content goes here.";
        String actualLabelText = labelText.getText();
        Assert.assertEquals(actualLabelText, expectedLabelText);

        //5- Verify the header ‘An iFrame containing the TinyMCE WYSIWYG Editor’
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeaderText = headerText.getText();
        Assert.assertEquals(actualHeaderText, expectedHeaderText);

    }

 /*   @AfterMethod
    public void closeDriver(){
        driver.close();
    }

  */

    @Test
    public void verify_BOTTOM_label(){

        //TC 2: As a User I should be able to see BOTTOM label


        //Click Frame
        WebElement frameLink = driver.findElement(By.xpath("//ul//li[22]/a"));
        frameLink.click();

        //3- Click Nested Frames
        WebElement nestedFramesLink = driver.findElement(By.xpath("//ul//li[1]/a"));
        nestedFramesLink.click();

        //4- Verify the BOTTOM label
        WebElement bottomIFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomIFrame);

        WebElement bodyBottom = driver.findElement(By.xpath("//body"));

        String expectedBottomLabel = "BOTTOM";
        String actualBOTTOMLabel = bodyBottom.getText();

        Assert.assertEquals(actualBOTTOMLabel, expectedBottomLabel);
    }

    @Test
    public void verify_MIDDLE_label(){

        //TC 3: As a User I should be able to see MIDDLE label

        //Click Frame
        WebElement frameLink = driver.findElement(By.xpath("//ul//li[22]/a"));
        frameLink.click();

        //3- Click Nested Frames
        WebElement nestedFramesLink = driver.findElement(By.xpath("//ul//li[1]/a"));
        nestedFramesLink.click();

        //4- Verify the MIDDLE label

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

        String expectedMiddleLabel = "MIDDLE";
        String actualMiddleLabel = driver.findElement(By.xpath("//body/div")).getText();

        Assert.assertEquals(actualMiddleLabel, expectedMiddleLabel);

    }

    @Test
    public void verify_RIGHT_and_LEFT_label(){

        //TC 4: As a User I should be able to see RİGHT label and LEFT label

        //Click Frame
        WebElement frameLink = driver.findElement(By.xpath("//ul//li[22]/a"));
        frameLink.click();

        //3- Click Nested Frames
        WebElement nestedFramesLink = driver.findElement(By.xpath("//ul//li[1]/a"));
        nestedFramesLink.click();

        //4- Verify the RİGHT label

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));

        String expectedRightLabel = "RIGHT";
        String actualRightLabel = driver.findElement(By.xpath("//body")).getText();

        Assert.assertEquals(actualRightLabel, expectedRightLabel);

        //5- Verify the LEFT label

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));

        String expectedLeftLabel = "LEFT";
        String actualLeftLabel = driver.findElement(By.xpath("//body")).getText();

        Assert.assertEquals(actualLeftLabel, expectedLeftLabel);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

