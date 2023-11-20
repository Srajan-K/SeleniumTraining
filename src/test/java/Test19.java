import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Test19 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("__incognito");
        driver.get("https://www.naturesbasket.co.in/");
        driver.findElement(By.id("btnClosePopUpBox")).click();
        WebElement dropdown = driver.findElement(By.id("ctl00_ddlCitySearch"));
        Select select = new Select(dropdown);
        select.selectByValue("kolkata");
        driver.findElement(By.id("btnPinOk")).click();
        driver.findElement(By.id("btnClosePopUpBox")).click();
        driver.findElement(By.xpath("//input[@value='Enter Pin']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Delivery pincode']"))).sendKeys("700001");
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='OK']"))).click();
        driver.findElement(By.id("btnClosePopUpBox")).click();
        WebElement startSearching = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='ctl00$txtMasterSearch1']"))));
        actions.moveToElement(startSearching).build().perform();
        WebElement chocolate = driver.findElement(By.xpath("//a[text()='Chocolates']"));
        actions.click(chocolate).build().perform();
        List<WebElement> listChocolate = driver.findElements(By.xpath("//div[@class='search_AddCart1 ']"));
        js.executeScript("arguments[0].click();", listChocolate.get(0));
        js.executeScript("arguments[0].click();", listChocolate.get(1));
        driver.findElement(By.xpath("//a[contains(text(),'Lindt Gold Bar Hazelnut 300G')]")).click();
        WebElement head=driver.findElement(By.xpath("(//h1[@class='pd_Title'])[1]"));
        String heading=head.getText();
        System.out.println(heading);
        actions.moveToLocation(head.getLocation().x+1,head.getLocation().y+1).clickAndHold().moveByOffset(0, head.getSize().getHeight() - 1).release().build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblCategoryName']")).click();
        for (int i = 0; i < 100; i++) {
            js.executeScript("window.scrollBy(0,350)", "");
        }
        WebElement emailField=driver.findElement(By.xpath("//input[@name='ctl00$txtNewletter']"));
        emailField.sendKeys("Dummy@gmail.com");
        actions.keyDown(emailField,Keys.CONTROL).sendKeys("a").keyDown(Keys.BACK_SPACE).sendKeys("v").build().perform();
       // TakesScreenshot screenshot= (TakesScreenshot) driver;
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Shutterbug.shootPage(driver, Capture.FULL,true).withName(heading+""+timeStamp).save("./Screenshot");
//        File screenshots=screenshot.getScreenshotAs(OutputType.FILE);

//        FileUtils.copyFile(screenshots,new File("./Screenshot/"+heading+""+timeStamp+".png"));
        driver.quit();
    }
}
