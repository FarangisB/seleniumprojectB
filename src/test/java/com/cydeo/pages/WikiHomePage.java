package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(xpath = "//i[.='Search']")
    public WebElement searchBtn;

    public void go_to_homepage_print_steve_jobs_and_click_search(){

        //1. User is on Wikipedia home page
        Driver.getDriver().get("https://www.wikipedia.org/");

        //2. User types Steve Jobs in the wiki search box
        searchBox.sendKeys("Steve Jobs");

        //3. User clicks wiki search button
        searchBtn.click();


    }

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    @FindBy(className = "fn")
    public WebElement imageHeader;

    public WikiHomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
