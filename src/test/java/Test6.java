import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test6 {
    public static void main(String[] args) throws InterruptedException {


            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
            WebElement dropdown=driver.findElement(By.id("course"));
            Select select=new Select(dropdown);
            select.selectByIndex(1);
            System.out.println(select.getFirstSelectedOption().getText());
            Thread.sleep(2000);
            select.selectByVisibleText("Dot Net");
            Thread.sleep(2000);
            select.selectByValue("python");
            Thread.sleep(2000);
            driver.quit();

    }
}
