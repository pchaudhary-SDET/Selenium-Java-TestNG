package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.ConfigReader;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver(){
     
      
        String browser= ConfigReader.getProperty("BROWSER");
        Boolean isheadless = Boolean.parseBoolean(ConfigReader.getProperty("HEADLESS"));
        Boolean ismaximized = Boolean.parseBoolean(ConfigReader.getProperty("WINDOW_MAXIMIZE"));

        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
             
           if(isheadless){

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");

             }

            driver = new ChromeDriver(options);
            
        }else{
            throw new RuntimeException("Browser not supported yet" + browser);
        }
        
        if(ismaximized){
                driver.manage().window().maximize();
            }

            driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("IMPLICIT_WAIT"))));
            driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("PAGELOAD_TIMEOUT"))));
        return driver;
    }


    public static WebDriver getDriver(){
        if(driver==null){
            initDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver !=null){
            driver.quit();
            driver=null;
        }
        
    }

}
