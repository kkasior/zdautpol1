package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utills.PropertiesManager;

public class BaseDriver {
    public static WebDriver initializeChromeDriverInHeadlessMode() {
        PropertiesManager propertiesManager = new PropertiesManager();
        String testingType = propertiesManager.getTestingTypeFromProperties();
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        if(testingType.equals("headless")){
            ChromeOptions opt = new ChromeOptions();
            opt.setHeadless(true);
            driver = new ChromeDriver(opt);
        }
        else{
            driver = new ChromeDriver();
        }
        return driver;
    }
}
