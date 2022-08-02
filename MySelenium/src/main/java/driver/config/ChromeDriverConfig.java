package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfig extends BaseDriverConfig {

    public String extensionPath;

    @Override
    public WebDriver createDriver(String pathToChromeDriver) {
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();

        configureWaits(driver);
        driver.manage().window().maximize();

        return driver;
    }

}
