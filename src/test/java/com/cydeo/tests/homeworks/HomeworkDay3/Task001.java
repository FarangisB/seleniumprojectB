package com.cydeo.tests.homeworks.HomeworkDay3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task001 {

    public static void main(String[] args) {

    //    TC #1: NextBaseCRM, locators and getText() practice
    //    1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

    //    2. Go to: https://login1.nextbasecrm.com/
            driver.get("https://login1.nextbasecrm.com/");

    //    3. Enter incorrect username: “incorrect”
            WebElement usernameBtn = driver.findElement(By.className("login-inp"));
            usernameBtn.sendKeys("incorrect");

    //    4. Enter incorrect password: “incorrect”
            WebElement passwordBtn = driver.findElement(By.name("USER_PASSWORD"));
            passwordBtn.sendKeys("incorrect");

    //    5. Click to Log in button.
            WebElement logInBtn = driver.findElement(By.className("login-btn"));
            logInBtn.click();

    //    6. Verify error message text is as expected:
    //    Expected: Incorrect login or password
        WebElement errorMsgeText = driver.findElement(By.className("errortext"));
        String expectedErrorMsgeText = "Incorrect login or password";
        String actualErrorMsgeText = errorMsgeText.getText();

        if (expectedErrorMsgeText.equals(actualErrorMsgeText)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

        driver.close();




    }
}
