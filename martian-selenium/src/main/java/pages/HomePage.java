package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By profileName=By.xpath("//a[@id='username']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        //TODO Auto-generated constructor stub
    }
    
    public Boolean IsDisplayed(){

        try {

            return isDisplayed(profileName);
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
