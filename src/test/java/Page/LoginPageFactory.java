package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    public LoginPageFactory(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.NAME,using = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement loginBtn;

    public void enterUserName(String uName){
        userName.sendKeys(uName);
    }

    public void enterPassword(String uPass){
       password.sendKeys(uPass);
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
