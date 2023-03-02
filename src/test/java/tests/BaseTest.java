package tests;

import configuration.ConfigProperties;
import driver.Driver;
import driver.config.BaseDriverConfig;
import configuration.DriverConfigFactory;
import driver.config.BrowserType;
import helpers.PropertyHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import settings.TestWatcher;


import java.util.Properties;

import static driver.Driver.getDriver;

@Listeners(TestWatcher.class)
public class BaseTest {
    private static BaseDriverConfig baseDriverConfig = new DriverConfigFactory().getConfig(BrowserType.Chrome);

    @BeforeSuite
    public void onStart() {
        String runPropFile = System.getProperty("user.dir") + "\\target\\test-classes\\run.properties";
        Properties runProperties = PropertyHelper.initProperty(runPropFile);

        ConfigProperties.init(String.format("src\\test\\resources\\config.%s.properties", runProperties.getProperty("environment")));
    }

    @BeforeMethod
    public void setUp() {
        Driver.instance.set(new Driver(baseDriverConfig));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

}
