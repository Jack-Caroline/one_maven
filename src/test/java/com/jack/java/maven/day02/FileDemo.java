package com.jack.java.maven.day02;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 判断目录是否存在，存在：true，不存在：false
        String path1 = "src/test/java/com.jack.java.mmm/ccc.txt";
        File file = new File(path1);
        File dir = new File("src/test/java/com.jack.java.mmm");
        System.out.println(file.exists());
        dir.mkdirs();  // 创建目录
        file.createNewFile(); // 创建文件
        System.out.println(file.exists());
        System.out.println("-----------------");
        System.out.println(file.isDirectory());
        System.out.println(dir.isDirectory());
    }
}
