package pageObjectModelAssignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFactory {
    public HomePageFactory(WebDriver driver){
        AjaxElementLocatorFactory ajaxElementLocatorFactory=new AjaxElementLocatorFactory(driver,20);
        PageFactory.initElements(ajaxElementLocatorFactory,this);
    }

    @FindBy(how = How.CLASS_NAME, using= "bm-burger-button")
    @CacheLookup
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    private WebElement logout;

    public void openMenu(){
        menu.click();
    }

    public void clickLogOut(){
        logout.click();
    }

}
