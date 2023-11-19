import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test8 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radio2=driver.findElement(By.xpath("//input[@value='radio2']"));
        WebElement option1=driver.findElement(By.id("checkBoxOption1"));
        WebElement option2=driver.findElement(By.id("checkBoxOption2"));
        WebElement option3=driver.findElement(By.id("checkBoxOption3"));
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        radio2.click();
        option2.click();
        option1.click();
        option3.click();
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        select.selectByValue("option2");
        select.selectByVisibleText("Option3");
        driver.quit();
    }
}
