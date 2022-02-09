package com.cydeo.tests.homeworks.HomeworkDay3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task004 {

    public static void main(String[] args) {

    //    TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
    //    1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

    //    2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

    //    3- Verify “Reset password” button text is as expected:
    //    Expected: Reset password
    //    WebElement resetPasswordBtnText = driver.findElement(By.cssSelector("button[class='login-btn']"));
    //    WebElement resetPasswordBtnText = driver.findElement(By.cssSelector("button[value='Reset password']"));
        WebElement resetPasswordBtnText = driver.findElement(By.cssSelector("button[onclick='BX.addClass(this, \\'wait\\');']"));
        String expectedPasswordBtnText = "Reset password";
        String actualPasswordBtnText = resetPasswordBtnText.getText();

        if(actualPasswordBtnText.equals(expectedPasswordBtnText)){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Not Passed!");
        }


    }
}
