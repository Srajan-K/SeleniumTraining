
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;
import java.io.FileOutputStream;
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
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        // Resize the image to fit a standard page size
        int maxWidth = (int) PageSize.A4.getWidth();
        int maxHeight = (int) PageSize.A4.getHeight();
//        screenshot = new AShot()
//                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
//                .takeScreenshot(driver, screenshot.getViewportSize());
//        screenshot = new AShot()
//                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
//                .takeScreenshot(driver, screenshot.getViewportSize());
//        screenshot = new AShot()
//                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
//                .takeScreenshot(driver, screenshot.getViewportSize())
//                .scaleTo(maxWidth, maxHeight);
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        //Shutterbug.shootPage(driver, Capture.FULL,true).withName(heading+""+timeStamp).save("./Screenshot");
        File screenshotFile = new File("./Screenshot/"+heading+""+timeStamp+".pdf");
        try {
            // Convert the screenshot to an iText Image
            Image image = Image.getInstance(screenshot.getImage(), null);

            // Create a new Document with the size of the captured screenshot
            Document document = new Document(image);

            // Create a PdfWriter and add the image to the PDF
            PdfWriter.getInstance(document, new FileOutputStream(screenshotFile));
            document.open();
            document.add(image);
            document.close();

            System.out.println("Full-page screenshot saved as PDF successfully");

            System.out.println("Screenshot saved as PDF successfully");
        } catch (IOException | DocumentException e) {
            System.err.println("Error saving screenshot as PDF: " + e.getMessage());
            e.printStackTrace();
        }


//        FileUtils.copyFile(screenshots,new File("./Screenshot/"+heading+""+timeStamp+".png"));
        driver.quit();
    }
}
