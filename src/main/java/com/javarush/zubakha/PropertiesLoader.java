package com.javarush.zubakha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    public PropertiesLoader(String filePath) {
        properties = new Properties();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {

        try (InputStream fis = PropertiesLoader.class.getResourceAsStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            logger.debug("ERROR: Properties file missing!", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
