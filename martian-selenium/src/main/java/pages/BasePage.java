package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver=driver;
        int timeout = Integer.parseInt(ConfigReader.getProperty("EXPLICIT_WAIT"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);;
    }

    protected String getText(By locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected Boolean isDisplayed(By locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    
}
