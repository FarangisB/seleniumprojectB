package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter

    public static void loginToSmartBear(WebDriver driver){

        //1. Enter username: “Tester”
        WebElement usernameBtn = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameBtn.sendKeys("Tester");

        //2. Enter password: “test”
        WebElement passwordBtn = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBtn.sendKeys("test");

        //3. Click to Login button
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBtn.click();
    }

    public static void logoutFromSmartBear(WebDriver driver){

        WebElement logoutBtn = driver.findElement(By.id("ctl00_logout"));
        logoutBtn.click();


    }


}
