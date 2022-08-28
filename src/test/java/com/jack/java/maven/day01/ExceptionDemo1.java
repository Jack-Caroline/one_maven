package com.jack.java.maven.day01;

import java.io.*;
import java.util.Properties;

public class ExceptionDemo1 {
    public static void main(String[] args) throws IOException {
        // 获取 properties 对象
        Properties properties = new Properties();
        // 根据文件路径创建文件对象
        File file = new File("src/test/log4j.properties");
        // 传入文件对象准备输入流对象
        // FileNotFoundException(编译时异常)
        InputStream inStream = new FileInputStream(file);
        // 调用 load 方法从输入流中加载数据到对象中
        // IOException(编译时异常)
        properties.load(inStream);
        System.out.println(properties.get("log4j.rootLogger"));
    }
}
