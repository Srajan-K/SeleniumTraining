import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://93.90.204.96/VSM3Test/ui/auth/signin");
        driver.quit();
    }
}
