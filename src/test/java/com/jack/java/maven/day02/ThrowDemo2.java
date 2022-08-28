package com.jack.java.maven.day02;

import java.io.*;
import java.util.Properties;

/*
    异常处理机制，捕获机制
 */
public class ThrowDemo2 {
    public static void main(String[] args) {
        String filePath = "src/test/resources/log4j.properties";
        loadProperties(filePath);
    }

    private static void loadProperties(String filePath) {
        // 准备文件对象
        File file = new File(filePath);
        // 将文件里面的内容读取到输入流对象中
        InputStream iStream = null;
        try {
            iStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件" + e);
        }
        Properties properties = new Properties();
        try {
            properties.load(iStream);
        } catch (IOException e) {
            System.out.println("IO 异常" + e);
        }
        System.out.println(properties.getProperty("log4j.rootLogger"));
    }
}
