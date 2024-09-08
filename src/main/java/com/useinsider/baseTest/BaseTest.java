package com.useinsider.baseTest;

import com.useinsider.driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class BaseTest {

    @BeforeClass
    public static void setUp(){
        Driver.getDriver().get("https://useinsider.com/");
        Driver.getDriver().manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        Driver.close();
    }

}
