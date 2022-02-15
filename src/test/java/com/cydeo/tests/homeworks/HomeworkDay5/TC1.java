package com.cydeo.tests.homeworks.HomeworkDay5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC1 {

    public static void main(String[] args) {
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementBtn.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn = driver.findElement(By.xpath("//div/button[@class]"));

        if(deleteBtn.isDisplayed()){
            System.out.println("Delete button is displayed");
        }else{
            System.out.println("Delete button is not displayed");
        }

        //5. Click to “Delete” button.
       deleteBtn.click();

        //6. Verify “Delete” button is NOT displayed after clicking.

        try{
            deleteBtn.isDisplayed();
        }catch (StaleElementReferenceException e){
            System.out.println("Delete button is not displayed");

        }



        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS



    }
}
/**
 * TC #1: StaleElementReferenceException handling
 * 1. Open Chrome browser
 * 2. Go to https://practice.cydeo.com/add_remove_elements/
 * 3. Click to “Add Element” button
 * 4. Verify “Delete” button is displayed after clicking.
 * 5. Click to “Delete” button.
 * 6. Verify “Delete” button is NOT displayed after clicking.
 * USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 *
 */
