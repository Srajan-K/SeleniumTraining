import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/index.html");
        WebElement element=driver.findElement(By.id("framestest"));
        element.click();
        WebElement leftFrame=driver.findElement(By.xpath("//frame[@name='left']"));
        WebElement middleFrame=driver.findElement(By.xpath("//frame[@name='middle']"));
        WebElement rightFrame=driver.findElement(By.xpath("//frame[@name='right']"));

        driver.switchTo().frame(leftFrame);
        WebElement leftElement=driver.findElement(By.id("left0"));
        System.out.println(leftElement.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(middleFrame);
        WebElement middleElement=driver.findElement(By.id("middle0"));
        System.out.println(middleElement.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(rightFrame);
        WebElement rightElement=driver.findElement(By.id("right0"));
        System.out.println(rightElement.getText());

        driver.quit();
    }
}
