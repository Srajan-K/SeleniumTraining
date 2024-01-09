package testNGAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    public WebDriver getDriver(String browser) {
        if (browser.equals("Chrome")) {
            return new ChromeDriver();
        } else if (browser.equals("Mozilla")) {
            return new FirefoxDriver();
        }
        return null;
    }

    @BeforeMethod
    @Parameters("browser")
    public void launchBrowser(String browser){
        driver=getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    @Parameters({"username","password"})
    public void invalidLogin(String username,String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String text=driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(text.contains("Epic sadface:"));
    }

    @Test(priority = 2,dataProvider = "Positive Login")
    public void validLogin(String username,String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory.html"));
    }

    @DataProvider(name = "Positive Login")
    public Object[][] credentials(){
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
