package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverConfig extends BaseDriverConfig {

    public String extensionPath;

    @Override
    public WebDriver createDriver(String pathToChromeDriver) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY,option);
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        WebDriver driver = new ChromeDriver(capabilities);

        configureWaits(driver);
        driver.manage().window().maximize();

        return driver;
    }

}
