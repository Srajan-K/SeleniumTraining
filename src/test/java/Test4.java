import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Test4 {
    public static void main(String[] args){

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://zero.webappsecurity.com/login.html");
    String url=driver.getCurrentUrl();
    String title=driver.getTitle();
        System.out.println("URL -> "+url);
        System.out.println("TITLE -> "+title);
        List<WebElement> elements=driver.findElements(By.tagName("label"));
        for(WebElement we:elements){
            System.out.println(we.getText());
            System.out.println(we.getAttribute("for"));
        }
        WebElement userName=driver.findElement(By.id("user_login"));
        WebElement checkBox=driver.findElement(By.xpath("//input[@id='user_remember_me']"));
        WebElement button=driver.findElement(By.xpath("//input[@value='Sign in']"));
        System.out.println(userName);
        userName.sendKeys("UserName1");
        userName.clear();
        System.out.println("Displayed "+userName.isDisplayed());
        System.out.println("Location "+userName.getLocation());
        System.out.println("Size "+userName.getSize());
        System.out.println("Selected "+checkBox.isSelected());
        System.out.println(driver.getPageSource());
        System.out.println("Windows "+driver.getWindowHandle());
        System.out.println("Enabled "+button.isEnabled());
        button.submit();
        driver.findElement(By.xpath("//a[contains(text(),'https://www.microfocus.com/about/legal/#privacy')]")).click();
        Set<String> windows=driver.getWindowHandles();
        for(String handle:windows){
            driver.switchTo().window(handle);
        }
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        driver.navigate().back();
//        driver.close();
        driver.quit();

    }
}
