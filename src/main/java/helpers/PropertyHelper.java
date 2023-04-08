package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {

    public static Properties initProperty(String pathToPropertiesFile) {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(pathToPropertiesFile);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  properties;
    }
}
