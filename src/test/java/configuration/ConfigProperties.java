package configuration;

import helpers.PropertyHelper;

import java.util.Properties;

public class ConfigProperties {

    private static Properties properties;

    public static void init(String path) {
        properties = PropertyHelper.initProperty(path);
    }

    public static String developersUrl()
    {
        return properties.getProperty("urlSapDeveloper");
    }

    public static String sapUrl()
    {
        return properties.getProperty("urlSap");
    }
}
