package com.cydeo.tests.homeworks.HomeworkDay8;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }


    @Test
    public void find_the_links(){

  /*      //3. Enter username: “Tester”
        WebElement usernameBtn = driver.findElement(By.id("ctl00_MainContent_username"));
                usernameBtn.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement passwordBtn = driver.findElement(By.id("ctl00_MainContent_password"));
                passwordBtn.sendKeys("test");

        //5. Click to Login button
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
                loginBtn.click();

   */

        SmartBearUtils.loginToSmartBear(driver);

        //6. Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("links.size() = " + links.size());


        //7. Print out each link text on this page

        for (WebElement link : links) {
            System.out.println(link.getText());
        }

    }

    @AfterMethod
    public void closeDriver(){

        SmartBearUtils.logoutFromSmartBear(driver);

        driver.close();


    }










}
