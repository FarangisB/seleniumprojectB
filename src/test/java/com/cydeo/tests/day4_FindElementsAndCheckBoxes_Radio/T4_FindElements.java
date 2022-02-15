package com.cydeo.tests.day4_FindElementsAndCheckBoxes_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_FindElements {

    public static void main(String[] args) {

    //    TC #4: FindElements Task
    //    1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //    2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

    //    3- Locate all the links in the page.
    // shortcut to create a Web element - driver.findElements(By.tagName("a"));+alt+Enter and again Enter
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

    //    4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());


        for (WebElement link : allLinks) {
            System.out.println("link.getText() = " + link.getText());

        }
        //    5- Print out the texts of the links.

    //    6- Print out the HREF attribute values of the links
        for (WebElement link : allLinks) {
            System.out.println("HREF Values: = "+link.getAttribute("href"));
        }



    }
}
