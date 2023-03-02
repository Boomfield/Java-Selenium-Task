package configuration;

import driver.config.BaseDriverConfig;
import driver.config.BrowserType;
import driver.config.FirefoxDriverConfig;
import driver.config.builder.ChromeBuilder;

public class DriverConfigFactory {
    public BaseDriverConfig getConfig(BrowserType browserType) {
        switch (browserType) {
            case Chrome:
                return new ChromeBuilder()
                        .withTimePageLoad(60)
                        .withTimeElementWait(40)
                        .build();
            case Firefox:
                return new FirefoxDriverConfig();
            default:
                throw new IllegalArgumentException("bad browser name");
        }
    }
}