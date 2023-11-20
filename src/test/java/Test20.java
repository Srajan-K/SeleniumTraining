import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Test20 {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
        Dimension size=driver.manage().window().getSize();
        Point position=driver.manage().window().getPosition();
        System.out.println("width : "+size.getWidth()+" Height : "+size.getHeight());
        System.out.println("X : "+position.x+" Y : "+position.y);
//        driver.manage().window().setSize(new Dimension(1000,750));
//        driver.manage().window().setPosition(new Point(120,80));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("URL: "+driver.getCurrentUrl());
        WebElement option2= driver.findElement(By.id("checkBoxOption2"));
        option2.click();
        WebElement activeElement=driver.switchTo().activeElement();
        System.out.println("Active element: "+activeElement.getTagName());
       // driver.manage().window().minimize();
        WebElement alert= driver.findElement(By.id("alertbtn"));
        alert.click();
        System.out.println("Alert text: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement confirmBtn= driver.findElement(By.id("confirmbtn"));
        confirmBtn.click();
        driver.switchTo().alert().dismiss();
        driver.navigate().to("https://www.browserstack.com/guide/handle-multiple-windows-in-selenium");
        driver.navigate().back();
        URL url=new URL("https://www.goibibo.com/");
        driver.navigate().to(url);
        driver.navigate().back();
        driver.navigate().refresh();
        List<WebElement> options=driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
        String parentWindow= driver.getWindowHandle();
        WebElement window=driver.findElement(By.id("openwindow"));
        window.click();
        driver.switchTo().window(parentWindow);
        WebElement tab=driver.findElement(By.id("opentab"));
        tab.click();
        driver.switchTo().window(parentWindow);
        Set<String> windows=driver.getWindowHandles();
        System.out.println(windows);
        WebElement frame= driver.findElement(By.id("courses-iframe"));
//        driver.switchTo().frame("courses-iframe");
        driver.switchTo().frame(frame);
        WebElement joinNow=driver.findElement(By.xpath("//a[contains(@class,'btn-theme btn-sm')]"));
        joinNow.click();
        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
        System.out.println(driver.getPageSource());
        System.out.println("Title: "+driver.getTitle());
        System.out.println(driver.manage().logs().get("browser"));
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        Set<Cookie> cookies=driver.manage().getCookies();
        for(Cookie cookie:cookies){
            System.out.println(driver.manage().getCookieNamed(cookie.getName()));
        }
        //driver.close();
        driver.quit();
    }
}
