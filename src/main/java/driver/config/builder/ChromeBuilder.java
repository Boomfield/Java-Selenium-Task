package driver.config.builder;

import driver.config.ChromeDriverConfig;

public class ChromeBuilder extends BaseDriverBuilder {

    public ChromeBuilder() {
        baseDriverConfig = new ChromeDriverConfig();
    }

    public ChromeBuilder withExtensionPath(String extensionPath) {
        ((ChromeDriverConfig) baseDriverConfig).extensionPath = extensionPath;
        return this;
    }

}
