package com.useinsider.methods;

import com.useinsider.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    public JavascriptExecutor jsDriver;
    Actions actions;

    public Methods() {
        jsDriver = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
    }


    public static WebDriverWait getWaiter(long seconds) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }


    public void switchTab(int tabNumber) {

        Driver.getDriver().switchTo().window(listTabs().get(tabNumber - 1));
    }

    public List<String> listTabs() {
        List<String> list = new ArrayList<String>();
        for (String window : Driver.getDriver().getWindowHandles()) {
            list.add(window);
        }
        return list;
    }

    public WebElement waitForVisibility(WebElement element) {
        return getWaiter(30).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitFor(int seconds) {
        waitByMilliSeconds(Duration.ofSeconds(30).toMillis());
    }

    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void waitForJQueryLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            assert js != null;
            return (Boolean) js.executeScript("return (typeof jQuery != 'undefined' && jQuery.active == 0);");
        };

        wait.until(jQueryLoad);
    }

    public void selectFromDD(WebElement element, String visibleText) {
        if (element != null) {
            jsDriver.executeScript("arguments[0].setAttribute('aria-hidden', 'false');", element);
            Select selectDD = new Select(element);
            long startTime = System.currentTimeMillis();
            while (!(selectDD.getOptions().size() > 1)) {
                if (System.currentTimeMillis() - startTime > 30000) {
                    Assert.fail("Waited for dropdown for 30 seconds to be loaded. It didn't load.");
                }
            }
            try {
                selectDD.selectByVisibleText(visibleText);
            } catch (NoSuchElementException e) {
                Assert.fail(String.valueOf(e));
            }
        } else
            Assert.fail("Select object is null. It's not on page.");
    }

    public WebElement hoverToElement(WebElement element) {
        actions.moveToElement(element).perform();
        return element;
    }

}
