package com.javarush.zubakha;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertiesLoaderTest {
    @Test
    public void testLoadProperties() {

            PropertiesLoader loader = new PropertiesLoader("/config.properties");

            assertEquals("You've lost your memory. Accept the UFO challenge?", loader.getProperty("q.1"));

    }

    @Test
    public void testLoadNonexistentKey() {

            PropertiesLoader loader = new PropertiesLoader("/config.properties");

            assertNull(loader.getProperty("anyKey"));

    }
}

