package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void Setup(){
        driver= DriverFactory.initDriver();
        driver.get(ConfigReader.getBaseUrl());
        
    }
    
    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
