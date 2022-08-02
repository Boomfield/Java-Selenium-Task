package tests;

import driver.Driver;
import driver.config.BaseDriverConfig;
import driver.config.DriverConfigFactory;
import helpers.BrowserType;
import helpers.PropertyHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private static BaseDriverConfig baseDriverBuilder = new DriverConfigFactory().getConfig(BrowserType.Chrome);

    @BeforeSuite
    public void onStart() throws IOException {
        String env = System.getProperty("conf");
        PropertyHelper.initProperty(String.format("src\\test\\resources\\config.%s.properties", "prod"));
    }

    @BeforeMethod
    public void setUp() {
        Driver.instance.set(new Driver(baseDriverBuilder));
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }

}
