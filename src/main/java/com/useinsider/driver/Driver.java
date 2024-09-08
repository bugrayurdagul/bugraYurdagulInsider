package com.useinsider.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--start-maximized");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        }
        return driver;
    }
    public static void close(){
        if(driver != null)
            driver.quit();
    }

}
