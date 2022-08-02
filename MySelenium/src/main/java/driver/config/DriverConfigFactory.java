package driver.config;

import helpers.BrowserType;

public class DriverConfigFactory {
    public BaseDriverConfig getConfig(BrowserType browserType) {
        switch (browserType) {
            case Chrome:
                return new ChromeBuilder().withTimePageLoad(60).withTimeElementWait(40).build();
            case Firefox:
                return new FirefoxDriverConfig();
            default:
                return null;
        }
    }
}
