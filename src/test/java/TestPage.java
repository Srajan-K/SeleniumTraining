import Page.LoginPage;
import Page.LoginPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPageFactory lp=new LoginPageFactory(driver);
        lp.enterUserName("Admin");
        lp.enterPassword("admin123");
        lp.clickLogin();

        driver.quit();
    }
}
