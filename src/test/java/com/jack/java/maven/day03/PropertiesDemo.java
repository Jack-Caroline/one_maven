package com.jack.java.maven.day03;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        String filePath="src/test/resources/log4j.properties";
        loadProperties(filePath);
    }

    private static void loadProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        InputStream iStream = new FileInputStream(new File(filePath));
        properties.load(iStream);
        System.out.println(properties.getProperty("log4j.appender.file"));
    }
}
