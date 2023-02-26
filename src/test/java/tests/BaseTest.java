package tests;

import driver.Driver;
import driver.config.BaseDriverConfig;
import driver.config.DriverConfigFactory;
import driver.config.BrowserType;
import helpers.PropertyHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import settings.TestWatcher;


import static driver.Driver.getDriver;

@Listeners(TestWatcher.class)
public class BaseTest {
    private static BaseDriverConfig baseDriverBuilder = new DriverConfigFactory().getConfig(BrowserType.Chrome);

    @BeforeSuite
    public void onStart() {
        String env = System.getProperty("conf");
        PropertyHelper.initProperty(String.format("src\\test\\resources\\config.%s.properties", "prod"));
    }

    @BeforeMethod
    public void setUp() {
        Driver.instance.set(new Driver(baseDriverBuilder));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

}
