package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By userName=By.name("username");
    private By password=By.name("password");
    private By loginBtn=By.tagName("button");

    public void enterUserName(String uName){
        driver.findElement(userName).sendKeys(uName);
    }

    public void enterPassword(String uPass){
        driver.findElement(password).sendKeys(uPass);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

}
