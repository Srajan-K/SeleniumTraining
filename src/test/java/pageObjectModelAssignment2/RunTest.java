package pageObjectModelAssignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RunTest {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        String text=driver.getCurrentUrl();
        if(text.contains("inventory.html")){
            System.out.println("Login Successful!!");
        }
        homePage.openMenu();
        homePage.clickLogOut();
        driver.quit();
    }
}
