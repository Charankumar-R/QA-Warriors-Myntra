package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static Properties readProperty() {

        String fileName = System.getProperty("user.dir")
                + "/src/test/resources/config.properties";

        FileInputStream fis;
        Properties prop = null;

        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }
}