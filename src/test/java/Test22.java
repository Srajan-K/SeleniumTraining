import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.net.MalformedURLException;

public class Test22 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement loginText=driver.findElement(RelativeLocator.RelativeBy.xpath("//label[text()='Login']"));
        WebElement password=driver.findElement(RelativeLocator.with(By.id("user_password")).below(loginText));
       password.sendKeys("1222");
    }
}
