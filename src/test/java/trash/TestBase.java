package trash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    WebDriver driver;
    @BeforeTest
    public void initiateDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver(){
        if(driver==null)
            throw new RuntimeException("Driver has not been initialized");
        return driver;
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
