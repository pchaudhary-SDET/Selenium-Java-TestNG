package tests;


import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void Setup(){
        driver= DriverFactory.initDriver();
       // driver.get(ConfigReader.getBaseUrl()); needed if we run junit tests
    }
    
    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
