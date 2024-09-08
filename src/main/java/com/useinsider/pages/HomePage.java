package com.useinsider.pages;

import com.useinsider.methods.Methods;
import com.useinsider.Pages;
import com.useinsider.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Methods {

    @FindBy(css = "#home_logo_reel")
    public WebElement div_HomePageCheck_HomePage;
    @FindBy(css = "#wt-cli-accept-all-btn")
    public WebElement btn_AcceptCookies_HomePage;
    @FindBy(xpath = "//a[normalize-space()='Company']")
    public WebElement dd_CompanyDropdown_HomePage;
    @FindBy(xpath = "//a[normalize-space()='Careers']")
    public WebElement dd_CareersDropdownSub_HomePage;

    protected final Pages pages = new Pages();


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void checkHomePageIsOpened() {
        try {
            waitForVisibility(div_HomePageCheck_HomePage);
        } catch (TimeoutException | NoSuchElementException e) {
            Assert.fail("Home Page didn't load properly or control item couldn't found on page. \n" + e);
        }
    }

    public void acceptCookies() {
        try {
            waitForVisibility(btn_AcceptCookies_HomePage).click();
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            throw new TimeoutException("Cookies container couldn't find on page or it is not clickable.", e);
        }
    }

    public void goToCareersPage() {
        if (dd_CompanyDropdown_HomePage.isDisplayed())
            dd_CompanyDropdown_HomePage.click();
        if (dd_CareersDropdownSub_HomePage.isDisplayed())
            dd_CareersDropdownSub_HomePage.click();
        try {
            waitForVisibility(pages.careersPage().a_FindYourDreamJobButton_CareersPage);
        } catch (TimeoutException e) {
            Assert.fail("Careers page didn't load or 'Find your dream job' button is now showing on page.");

        }

    }


}
