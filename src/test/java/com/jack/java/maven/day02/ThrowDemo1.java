package com.jack.java.maven.day02;

import java.io.*;
import java.util.Properties;

/*
    异常处理机制，抛出异常
 */
public class ThrowDemo1 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String filePath = "src/test/resources/log4j.properties";
        loadProperties(filePath);
    }

    private static void loadProperties(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        // 准备文件对象
        File file = new File(filePath);
        // 将文件里面的内容读取到输入流对象中
        InputStream iStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(iStream);
        System.out.println(properties.getProperty("log4j.rootLogger"));
        throw new ClassNotFoundException();
    }
}
