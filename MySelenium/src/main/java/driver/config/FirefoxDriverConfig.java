package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverConfig extends BaseDriverConfig {

    @Override
    public WebDriver createDriver(String pathToChromeDriver) {
        System.setProperty("webdriver.gecko.driver", pathToChromeDriver);
        WebDriver driver = new FirefoxDriver();

        return driver;
    }
}
