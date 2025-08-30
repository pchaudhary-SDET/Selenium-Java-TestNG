package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    
    private By loginbtn= By.xpath("//a[@role='button' and contains(@href,'login')]");

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public LoginPage gotoLoginPage(){
        click(loginbtn);
        return new LoginPage(driver);
    }


}
