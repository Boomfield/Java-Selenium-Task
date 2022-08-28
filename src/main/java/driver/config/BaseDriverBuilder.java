package driver.config;

import java.time.Duration;

public class BaseDriverBuilder {

    protected BaseDriverConfig baseDriverConfig;

    public BaseDriverBuilder withTimePageLoad(int second) {
        baseDriverConfig.timePageLoad = Duration.ofSeconds(second);
        return this;
    }

    public BaseDriverBuilder withTimeElementWait(int second) {
        baseDriverConfig.timeElementWait = Duration.ofSeconds(second);
        return this;
    }

    public BaseDriverConfig build() {
        return baseDriverConfig;
    }

}
