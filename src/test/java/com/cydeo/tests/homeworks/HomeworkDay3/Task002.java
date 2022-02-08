package com.cydeo.tests.homeworks.HomeworkDay3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task002 {

    public static void main(String[] args) {
    //  TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
    //  1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    // 2. Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

    // 3. Verify “remember me” label text is as expected: Expected: Remember me on this computer
        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedLabelText = "Remember me on this computer";
        String actualLabelText = rememberMe.getText();

        if(actualLabelText.equals(expectedLabelText)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

    // 4. Verify “forgot password” link text is as expected:
    // Expected: Forgot your password?
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordText = forgotPassword.getText();

        if(actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

    // 5. Verify “forgot password” href attribute’s value contains expected:
    // Expected: forgot_password=yes

        WebElement forgotPasswordHrefAttribute = driver.findElement(By.className("login-link-forgot-pass"));
        String forgotPasswordHrefAttributeContains = "forgot_password=yes";
        String actualForgotPasswordTextHrefAttribute = forgotPassword.getAttribute("href");

        if(actualForgotPasswordTextHrefAttribute.contains(forgotPasswordHrefAttributeContains)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Not Passed!");
        }

        driver.close();


    }
}
/**
 * TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
 * 1- Open a chrome browser
 * 2- Go to: https://login1.nextbasecrm.com/
 * 3- Verify “remember me” label text is as expected:
 * Expected: Remember me on this computer
 * 4- Verify “forgot password” link text is as expected:
 * Expected: Forgot your password?
 * 5- Verify “forgot password” href attribute’s value contains expected:
 * Expected: forgot_password=yes
 *
 *
 *
 * PS: Inspect and decide which locator you should be using to locate web
 * elements.
 */
//<a class="login-link-forgot-pass" href="/?forgot_password=yes">Forgot your password?</a>