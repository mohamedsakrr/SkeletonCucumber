package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // constructor
    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id= "username")
    WebElement usernamePF;


    public WebElement usernamePOM ()
    {
        By username = By.id("username");
        WebElement usernameEle = driver.findElement(username);
        return usernameEle;
    }

    public WebElement passwordPOM ( )
    {
        return  driver.findElement(By.name("password"));
    }

    public By flashPOM ( )
    {
        return  By.id("flash");
    }


    public By logoutPOM ( )
    {
        return  By.cssSelector("a[href=\"/logout\"]");
    }

    public void LoginSteps(String username, String password)
    {
        //Enter Username using POM
        usernamePF.clear();
        usernamePF.sendKeys(username);
        passwordPOM().sendKeys(password);


    }
}
