import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.browser.Browser;
import org.openqa.selenium.devtools.v118.emulation.Emulation;
import org.openqa.selenium.devtools.v118.log.Log;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.ConnectionType;
import org.openqa.selenium.devtools.v118.network.model.Cookie;
import org.openqa.selenium.devtools.v118.performance.Performance;
import org.openqa.selenium.devtools.v118.performance.model.Metric;
import org.openqa.selenium.devtools.v118.systeminfo.SystemInfo;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Test23 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://www.speedtest.net/"); //Net Speed
//        driver.get("https://mycurrentlocation.net/");// Location
//        driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php"); //log
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        DevTools ds = driver.getDevTools();
        ds.createSession();
        ds.send(Performance.enable(Optional.empty()));
        System.out.println("Can emulate : "+ds.send(Emulation.canEmulate()));
//        ds.send(Log.enable());
//        ds.addListener(Log.entryAdded(),
//                logEntry -> {
//                    System.out.println("Log Text : " + logEntry.getText());
//                    System.out.println("Log Level : " + logEntry.getLevel());
//                    System.out.println("Log Source : " + logEntry.getSource());
//                    System.out.println("URL : " + logEntry.getUrl().toString());
//                });
        Browser.GetVersionResponse browser = ds.send(Browser.getVersion());
        System.out.println(browser.getProduct());
        System.out.println(browser.getUserAgent());


        ds.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//        ds.send(Network.emulateNetworkConditions(
//                false,
//                4,
//                100,
//                200,
//                Optional.of(ConnectionType.CELLULAR2G)
//        ));
        List<Cookie> cookies = ds.send(Network.getCookies(Optional.empty()));

        List<Metric> metrics = ds.send(Performance.getMetrics());
        for(Metric metric:metrics){
            System.out.println("Name : "+metric.getName());
            System.out.println("Value :"+metric.getValue());
        }

        for(Cookie cookie:cookies){
            System.out.println(cookie.getName());
        }



//        ds.send(Emulation.setDeviceMetricsOverride(
//             375,
//                667,
//                50,
//                true,
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty(),
//                Optional.empty()
//        ));

//        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",Map.of(
//                "width",375,
//                "height",667,
//                "deviceScaleFactor",50,
//                "mobile",true
//        ));

//        WebElement detectLocation = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
//        ds.send(Emulation.setGeolocationOverride(
//                Optional.of(59.618849),
//                Optional.of(94.513750),
//                Optional.of(20)
//        ));
//        detectLocation.click();

//        ds.send(Emulation.clearGeolocationOverride());
        ds.send(Browser.close());
    }
}
