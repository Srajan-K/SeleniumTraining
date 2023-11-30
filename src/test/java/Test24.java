
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput;

public class Test24{
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("119");
        options.addArguments("--headless");
        SeleniumManagerOutput.Result path = SeleniumManager.getInstance().getDriverPath(options, false);
        System.out.println(path);
        SeleniumManager seleniumManager = SeleniumManager.getInstance();

    }
}
