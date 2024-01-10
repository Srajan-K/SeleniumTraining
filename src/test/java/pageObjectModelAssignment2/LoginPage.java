package pageObjectModelAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By username=By.id("user-name");

    private By password=By.id("password");

    private By btnLogin=By.id("login-button");

    public void enterUserName(String name){
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String Password){
        driver.findElement(password).sendKeys(Password);
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
}
