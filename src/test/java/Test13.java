import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://extendsclass.com/text-compare.html");
        Actions actions=new Actions(driver);
        WebElement box1=driver.findElement(By.xpath("//*[@id='dropZone']//div[5]//pre/span"));
        actions.keyDown(box1, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        WebElement box2= driver.findElement(By.xpath("//span[text()='File comparison can be very difficult, ']"));
        actions.keyDown(box2,Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE).sendKeys("v").build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}
