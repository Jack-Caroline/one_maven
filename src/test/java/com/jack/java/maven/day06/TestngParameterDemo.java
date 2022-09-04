package com.jack.java.maven.day06;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameterDemo {
    /**
     * 此方法能够根据浏览器类型
     */
    @Test
    @Parameters(value = {"browserType", "driverPath"})
    public void test(String browserType,String driverPath) {
        System.out.println("browserType = " + browserType);
        System.out.println("driverPath = " + driverPath);
    }
}
