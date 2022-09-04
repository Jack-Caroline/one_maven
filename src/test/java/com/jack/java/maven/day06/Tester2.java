package com.jack.java.maven.day06;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Tester2 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Tester2.beforeSuite()");
    }
    /**
     * 测试用例
     */
    @Test
    public void test(){
        System.out.println("Tester2.test()s");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Tester.AfterSuite()");
    }
}
