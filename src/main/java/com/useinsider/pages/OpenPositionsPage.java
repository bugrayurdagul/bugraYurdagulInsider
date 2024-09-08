package com.useinsider.pages;

import com.useinsider.driver.Driver;
import com.useinsider.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenPositionsPage extends Methods {
    @FindBy(css = "#filter-by-location")
    public WebElement slct_FindByLocation_OpenPositionsPage;
    @FindBy(css = "#filter-by-department")
    public WebElement slct_FilterByDepartment_OpenPositionsPage;
    @FindBy(css = "[data-location='istanbul-turkey'][data-team='qualityassurance']")
    public WebElement div_FilteredJobControl_OpenPositionsPage;

    @FindBy(css = "#jobs-list .position-list-item")
    public WebElement deneme;
    @FindBys(@FindBy(css = "#jobs-list .position-list-item"))
    public List<WebElement> div_FilteredJobs_OpenPositionsPage;

    public OpenPositionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void filterForQAJobs() {
        waitForJQueryLoad();
        selectFromDD(slct_FindByLocation_OpenPositionsPage, "Istanbul, Turkey");
        selectFromDD(slct_FilterByDepartment_OpenPositionsPage, "Quality Assurance");
        waitForJQueryLoad();
    }

    public void checkForJobListingsInfos() {
        div_FilteredJobs_OpenPositionsPage.forEach(element -> {
            Assert.assertTrue("Title doesn't contain Quality Assurance"
                    , element.findElement(By.cssSelector(".position-title"))
                            .getText().contains("Quality Assurance"));
            Assert.assertTrue("Department doesn't contain Quality Assurance"
                    , element.findElement(By.cssSelector(".position-department"))
                            .getText().contains("Quality Assurance"));
            Assert.assertTrue("Location doesn't contain Istanbul, Turkey"
                    , element.findElement(By.cssSelector(".position-location"))
                            .getText().contains("Istanbul, Turkey"));
        });
    }

    public void hoverAndClickViewRoleButton() {
        hoverToElement(div_FilteredJobs_OpenPositionsPage.get(0)
                .findElement(By.xpath("//a[normalize-space()='View Role']")))
                .click();
    }

    public void checkIfLeverPageRedirected() {
        if (listTabs().size() > 1) {
            switchTab(2);
            String tabURL = Driver.getDriver().getCurrentUrl();
            Assert.assertTrue("We are on wrong page!",
                    tabURL.contains("https://jobs.lever.co/useinsider"));
        } else
            Assert.fail("Not redirected to the Lever page.");
    }


}
