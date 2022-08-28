package com.jack.java.maven.day01;

import java.util.ArrayList;
import java.util.List;

public class Exceptiondemo2 {
    public static void main(String[] args) {
        // IndexOutOfBoundsException
        List<String> names = new ArrayList<String>();
        names.add("李雷");
        names.add("韩梅梅");
        System.out.println(names.get(3));
    }
}
