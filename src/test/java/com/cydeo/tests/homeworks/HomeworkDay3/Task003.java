package com.cydeo.tests.homeworks.HomeworkDay3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task003 {

    public static void main(String[] args) {

    //    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
    //    1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    //    2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

    //    3- Verify “Log in” button text is as expected:
    //    Expected: Log In
        WebElement logInBtn = driver.findElement(By.className("login-btn"));
        String expectedLogInBtn = "Log In";
        String actualLogInBtn = logInBtn.getAttribute("value");

        if (actualLogInBtn.equals(expectedLogInBtn)) {
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }





    }
}
/**
 * PS: Inspect and decide which locator you should be using to locate web
 *         elements.
 *                 PS2: Pay attention to where to get the text of this button from
 */

