package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
    public static String readKey(String key)
    {
        Properties properties = new Properties();
        try {
            FileInputStream  fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
