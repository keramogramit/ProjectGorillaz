package com.javarush.zubakha;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties;

    public PropertiesLoader(String filePath) {
        properties = new Properties();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {


        try (InputStream fis = PropertiesLoader.class.getResourceAsStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("ERROR: Properties file missing! Path:" );
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
