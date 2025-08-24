package StepDefinition;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver ;
    LoginPage login;

    @Given("user open Browser")
    public void user_open_browser () throws InterruptedException {
            // 2- New Object WebDriver
            driver = new ChromeDriver();

            // 4- New Object of Login page
            login = new LoginPage(driver);
            Thread.sleep(500);
        }


    @And("user navigate to login page")
    public void user_navigates ()
        {
            driver.navigate().to("https://the-internet.herokuapp.com/login");
        }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void valid_date (String username, String password)
        {
            login.LoginSteps( username,password);
        }


    @And("user click on login BTN")
    public void login_button ()
        {
           login.passwordPOM().sendKeys(Keys.ENTER);
        }

    @Then("user could login successfully")
    public void success_login () throws InterruptedException {
            Thread.sleep(300);
            String expectedResult = "You logged into a secure area!";
            String actualResult = driver.findElement(login.flashPOM()).getText();
            Assert.assertTrue(actualResult.contains(expectedResult));
        }


    @Then("user could not login")
    public void wrong_login ()
    {

        String expectedResult = "Your username is invalid!";
        String actualResult = driver.findElement(login.flashPOM()).getText();
        Assert.assertTrue("Error MSG : Text is wrong",actualResult.contains(expectedResult));
        System.out.println("actualResult: "+actualResult);
    }

    @And("user go to home page")
    public void home_page ()
    {
        Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
    }

    @After
    public void close_browser()
    {
        driver.quit();
    }
}
