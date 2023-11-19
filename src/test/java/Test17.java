import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test17 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Thread.sleep(2000);
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
        Actions actions=new Actions(driver);
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        actions.moveToElement(submit).click().build().perform();
        Thread.sleep(5000);
        actions.scrollByAmount(1400,680).build().perform();
        WebElement admin=driver.findElement(By.xpath("//span[text()='Admin']"));
        WebElement claim=driver.findElement(By.xpath("//span[text()='Claim']"));
        actions.dragAndDrop(admin,claim).build().perform();
        WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search']"));
        actions.click(search).build().perform();
        actions.sendKeys("Hello").build().perform();
        driver.quit();
    }
}
