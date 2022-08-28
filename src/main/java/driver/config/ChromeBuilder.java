package driver.config;

public class ChromeBuilder extends BaseDriverBuilder {

    public ChromeBuilder() {
        baseDriverConfig = new ChromeDriverConfig();
    }

    public ChromeBuilder withExtensionPath(String extensionPath) {
        ((ChromeDriverConfig) baseDriverConfig).extensionPath = extensionPath;
        return this;
    }

}
