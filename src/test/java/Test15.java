import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test15 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)", "");
        WebElement frame=driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
        driver.switchTo().frame(frame);
        WebElement joinNow=driver.findElement(By.xpath("//a[contains(@class,'btn-theme btn-sm')]"));
        js.executeScript("arguments[0].click();", joinNow);
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        File screenshots=screenshot.getScreenshotAs(OutputType.FILE);
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        FileUtils.copyFile(screenshots,new File("./Screenshot/"+timeStamp+"_scr.png"));
        driver.quit();
    }
}
