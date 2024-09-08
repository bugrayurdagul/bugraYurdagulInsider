package com.useinsider.pages;

import com.useinsider.methods.Methods;
import com.useinsider.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage extends Methods {
    @FindBy(xpath = "//a[normalize-space()='Find your dream job']")
    public WebElement a_FindYourDreamJobButton_CareersPage;
    @FindBy(id = "career-our-location")
    public WebElement sctn_OurLocationSection_CareersPage;
    @FindBy(id = "career-find-our-calling")
    public WebElement sctn_TeamsSection_CareersPage;
    @FindBy(xpath = "//h2[normalize-space()='Life at Insider']//ancestor::section")
    public WebElement sctn_LifeAtInsiderSection_CareersPage;


    public CareersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void checkBlocksAreOpen() {
        Assert.assertTrue("Teams Block didn't open.", sctn_TeamsSection_CareersPage.isDisplayed()
                && !sctn_TeamsSection_CareersPage.findElements(By.cssSelector("#career-find-our-calling .job-item div")).isEmpty());
        Assert.assertTrue("Locations Block didn't open.", sctn_OurLocationSection_CareersPage.isDisplayed()
                && !sctn_OurLocationSection_CareersPage.findElements(By.cssSelector("#career-our-location #location-slider li")).isEmpty());
        Assert.assertTrue("Life at Insider Block didn't open.", sctn_LifeAtInsiderSection_CareersPage.isDisplayed()
                && !sctn_LifeAtInsiderSection_CareersPage.findElements(By.xpath("//div[@role='img']")).isEmpty());
    }


}
