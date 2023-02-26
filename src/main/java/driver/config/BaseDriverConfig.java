package driver.config;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public abstract class BaseDriverConfig {

    public Duration timePageLoad;
    public Duration timeElementWait;

    public abstract WebDriver createDriver(String path);

    public void configureWaits(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(timePageLoad);
        driver.manage().timeouts().implicitlyWait(timeElementWait);
    }

}
