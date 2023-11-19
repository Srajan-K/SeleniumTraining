import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Test16 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airindia.com/in/en/book/search-flights.html");
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.id("From"));
        element.click();
        element.sendKeys("del");
        Thread.sleep(2000);
        List<WebElement> elementList=driver.findElements(By.xpath("//div[@class='row airport-country-detail']"));
        for(WebElement ele:elementList){
            if(ele.getText().trim().equalsIgnoreCase("Delhi, India, IN")){
                ele.click();
                break;
            }
        }
        driver.quit();
    }
}
