package com.cydeo.tests.homeworks.HomeworkDay8;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2 {


    //TC#2: Smartbear software order placing

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void verify_success_message(){

        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear(driver);

        //6. Click on Order
        driver.findElement(By.xpath("//li/a[.='Order']")).click();

        //7. Select familyAlbum from product, set quantity to 2
        Select dropdownProduct = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));

        dropdownProduct.selectByValue("FamilyAlbum");

        WebElement quantityBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBtn.sendKeys(Keys.BACK_SPACE);
        quantityBtn.sendKeys("2");

        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //9. Fill address Info with JavaFaker
        // Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        //name
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(faker.name().firstName()+" "+faker.name().lastName());
        //street
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(faker.address().streetName());
        //city
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(faker.address().cityName());
        //state
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(faker.address().state());
        //zip code
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(faker.numerify("#####"));

        //10. Click on “visa” radio button
        driver.findElement(By.xpath("//input[@value='Visa']")).click();

        //11. Generate card number using JavaFaker
        //used replaceAll() method of String to get rid of "-"

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(faker.business().creditCardNumber().replaceAll("-", ""));

        //Credit card expiration date
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys(faker.numerify("##/##"));

        //12. Click on “Process”
        driver.findElement(By.xpath("//a[.='Process']")).click();

        //13. Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.xpath("//div//strong"));
        String actualSuccessMsg = successMessage.getText();
        String expectedSuccessMsg = "New order has been successfully added.";

        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);

    }

    @AfterMethod
    public void closeDriver(){

       // SmartBearUtils.logoutFromSmartBear(driver);

       // driver.close();


    }





}

