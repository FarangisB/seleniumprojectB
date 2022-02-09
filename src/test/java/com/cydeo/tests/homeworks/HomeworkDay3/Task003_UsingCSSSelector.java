package com.cydeo.tests.homeworks.HomeworkDay3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task003_UsingCSSSelector {

    public static void main(String[] args) {

    //    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
    //    1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

    //    2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

    //    3- Verify “Log in” button text is as expected:
    //    Expected: Log In
    //    WebElement logInBtn = driver.findElement(By.cssSelector("input[type='submit']"));
    //    WebElement logInBtn = driver.findElement(By.cssSelector("input[value='Log In']"));
        WebElement logInBtn = driver.findElement(By.cssSelector("input[class='login-btn']"));
        String expectedLogInBtn = "Log In";
        String actualLogInBtn = logInBtn.getAttribute("value");

        if(expectedLogInBtn.equals(actualLogInBtn)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

        driver.close();




    }
}
