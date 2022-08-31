package com.jack.java.maven.day02;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String fromPath = "src/test/java/com.jack.java.mmm/ccc.txt";
        String toPath = "src/test/java/com.jack.java.mmm/ccc1.txt";
        InputStream inputStream = new FileInputStream(new File(fromPath));
        OutputStream outputStream = new FileOutputStream(new File(toPath));
        int size = 0;
        while ((size = inputStream.read()) != -1) {
            outputStream.write(size);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
        System.out.println("finish");
    }
}
