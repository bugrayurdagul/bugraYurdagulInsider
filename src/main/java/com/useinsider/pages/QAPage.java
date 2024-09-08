package com.useinsider.pages;

import com.useinsider.methods.Methods;
import com.useinsider.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAPage extends Methods {
    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    public WebElement a_SeeAllQAJobButton_QAPage;


    public QAPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToQAPage() {
        Driver.getDriver().navigate().to("https://useinsider.com/careers/quality-assurance/");
        try {
            waitForVisibility(a_SeeAllQAJobButton_QAPage);
        } catch (TimeoutException | NoSuchElementException e) {
            throw new TimeoutException("See all QA Jobs button is not on page. \n", e);
        }
    }

    public void goToQAOpenPositionsPage() {

        try {
            a_SeeAllQAJobButton_QAPage.click();
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            throw new StaleElementReferenceException("See all QA Jobs button can't be clickable \n", e);
        }
        Assert.assertEquals("We are not on the wanted 'QA Jobs Search' page.",
                Driver.getDriver().getCurrentUrl(), "https://useinsider.com/careers/open-positions/?department=qualityassurance");

    }


}
