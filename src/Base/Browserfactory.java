package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserfactory {

    public static WebDriver startBrowser() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addExperimentalOption("useAutomationExtension", false);
        
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}