import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class Test7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement windowButton = driver.findElement(By.xpath("//button[@id='openwindow']"));
        WebElement tabButton = driver.findElement(By.xpath("//a[@id='opentab']"));
        String window1 = driver.getWindowHandle();
        windowButton.click();
        Thread.sleep(5000);
        Set<String> windows1 = driver.getWindowHandles();
        for(String handel:windows1){
            if(!window1.equals(handel)) {
                driver.switchTo().window(handel);
            }
        }

        WebElement accessAllCourses= driver.findElement(By.xpath("//a[text()='Access all our Courses']"));
        accessAllCourses.click();
        Thread.sleep(5000);
        String window2 = driver.getWindowHandle();
        driver.switchTo().window(window1);
        tabButton.click();
        String tab=driver.getWindowHandle();
        Set<String> windows2=driver.getWindowHandles();
        Thread.sleep(2000);

        for(String handles:windows2){
            driver.switchTo().window(handles);
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
