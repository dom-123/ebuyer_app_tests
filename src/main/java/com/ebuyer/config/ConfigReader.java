package com.ebuyer.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String GLOBAL_PROPERTIES_PATH = "src//main//java//com//ebuyer//config//global.properties";

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty () throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(GLOBAL_PROPERTIES_PATH);
        prop.load(fis);

        Settings.siteUrl = prop.getProperty("siteUrl");
    }
}