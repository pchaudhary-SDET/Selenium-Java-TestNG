package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private WebDriver driver;

    private By emailField= By.id("email");
    private By passwordField= By.id("password");
    private By submitBtn=By.xpath("//button[@type=\"submit\"]");
    private By loginScreen = By.xpath("//div/h4[contains(text(),'Login')]");

    public LoginPage (WebDriver driver){
        super(driver);
        this.driver=driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginScreen));
    }

    public void enterEmail(String email){
        type(emailField,email);
    }

    public void enterPassword (String password){
        type(passwordField,password);
    }

    public Boolean isDisplayed(){
        try {
            return isDisplayed(loginScreen);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public HomePage clickSubmit(){
        click(submitBtn);
        return new HomePage(driver);
    }
    
}
