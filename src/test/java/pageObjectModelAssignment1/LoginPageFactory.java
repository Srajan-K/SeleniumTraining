package pageObjectModelAssignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPageFactory {
    public LoginPageFactory(WebDriver driver){
        AjaxElementLocatorFactory ajaxElementLocatorFactory=new AjaxElementLocatorFactory(driver,20);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
    }
    @FindBys({
            @FindBy (id = "user-name"),
            @FindBy(xpath = "//input[@type='text']")
    })
    @CacheLookup
    protected List<WebElement> userName;

    @FindBys({
            @FindBy( id= "password"),
            @FindBy(xpath = "//input[@type='password']")
    })
    @CacheLookup
    protected List<WebElement> password;

    @FindAll({
           @FindBy(id = "login-button"),
            @FindBy(className = "btn_action"),
            @FindBy(xpath = "//input[@type='submit']")
    })
    @CacheLookup
    protected WebElement btnLogin;

    public void enterUserName(String username){
        userName.get(0).sendKeys(username);
    }

    public void enterPassword(String pWord){
        password.get(0).sendKeys(pWord);
    }

    public void clickLogin(){
        btnLogin.click();
    }
}
