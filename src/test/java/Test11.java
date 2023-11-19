import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.goibibo.com/");
        driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
        driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='From']/following-sibling::input")).sendKeys("mang");
        List<WebElement> elements1=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li//p/span"));
            for (WebElement element:elements1){
                if(element.getText().split("\\(")[0].trim().equalsIgnoreCase("Mangalore, India")){
                    element.click();
                    break;
                }
            }

        driver.findElement(By.xpath("//span[text()='To']/following-sibling::input")).sendKeys("Bang");
        List<WebElement> elements2=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li//p/span"));
        for (WebElement element:elements2){
            if(element.getText().split("\\(")[0].trim().equalsIgnoreCase("Bengaluru, India")){
                element.click();
            }
        }


        driver.quit();
 }
}
