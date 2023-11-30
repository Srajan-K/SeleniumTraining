import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.net.MalformedURLException;

public class Test21 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radio1= driver.findElement(RelativeLocator.RelativeBy.xpath("//input[@value='radio1']"));
        WebElement radio2= driver.findElement(RelativeLocator.with(By.tagName("input")).below(radio1)); // below
        radio1.click();
        radio2.click();
       // WebElement dropdown=driver.findElement(RelativeLocator.RelativeBy.id("dropdown-class-example"));
        WebElement dropdown=driver.findElement(RelativeLocator.RelativeBy.cssSelector("#dropdown-class-example"));
      //  WebElement selectCountry=driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(dropdown)); //toLeftOf
        WebElement selectCountry=driver.findElement(RelativeLocator.with(By.id("autocomplete")).toLeftOf(dropdown));
        selectCountry.sendKeys("ind");
        WebElement option1=driver.findElement(RelativeLocator.with(By.id("checkBoxOption1")).toRightOf(dropdown)); //toRightOf
        option1.click();
        WebElement option3=driver.findElement(RelativeLocator.RelativeBy.name("checkBoxOption3"));
        WebElement option2= driver.findElement(RelativeLocator.with(By.name("checkBoxOption2")).above(option3)); //above
        option2.click();
        WebElement window=driver.findElement(RelativeLocator.with(By.id("openwindow")).near(radio1,180)); //near
        window.click();
        driver.quit();
    }
}
