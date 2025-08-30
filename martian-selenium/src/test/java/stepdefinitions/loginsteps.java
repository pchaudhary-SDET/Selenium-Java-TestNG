package stepdefinitions;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import utils.ConfigReader;

public class loginsteps {
    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("user is on landing page")
    public void user_is_on_landing_page(){
        landingPage = new LandingPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }
    
    @And("user clicks on login")
    public void user_clicks_on_login(){
        loginPage=landingPage.gotoLoginPage();
    }

    @Given("user is on login page")
 public void user_is_on_login_page(){
     loginPage.isDisplayed();
 }

    @And("user enters valid username and password")
    public void userenters_valid_credentials(){
        loginPage.enterEmail(ConfigReader.getProperty("email"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button(){
        homePage=loginPage.clickSubmit();
    }

    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_home(){
        Assert.assertTrue(homePage.IsDisplayed());
    }
}
