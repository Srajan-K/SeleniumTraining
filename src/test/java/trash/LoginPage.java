package trash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    protected WebElement userName;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "login-button")
    protected WebElement btnLogin;

    @FindBy(tagName = "h3")
    protected WebElement error;

    public void errorText(){
        System.out.println(error.getText());
    }

    public void enterUserName(String name){
        userName.sendKeys(name);
    }

    public void enterPassword(String pWord){
        password.sendKeys(pWord);
    }

    public void clickLogin(){
        btnLogin.click();
    }
}
