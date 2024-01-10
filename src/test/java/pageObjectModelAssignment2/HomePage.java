package pageObjectModelAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    private By breadCrumb=By.className("bm-burger-button");

    private By logOut=By.id("logout_sidebar_link");

    public void openMenu(){
        driver.findElement(breadCrumb).click();
    }

    public void clickLogOut(){
        driver.findElement(logOut).click();
    }

}
