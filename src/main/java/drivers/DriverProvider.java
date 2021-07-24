package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static WebDriver driver;
    private static WebDriverWait wait;


    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(final Browser browser) {
        if (driver == null) {
            init(browser);
        }
        return driver;
    }

    public static void flush() {
        driver.close();
        driver = null;
    }

    private static void init(final Browser browser) {
        switch (browser) {
            case CHROME:
                driver = new ChromeConfigurator().setup();
                break;
            case FIREFOX:
                driver = new FirefoxConfigurator().setup();
                break;
            default:
                driver = null;
        }
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }
}
