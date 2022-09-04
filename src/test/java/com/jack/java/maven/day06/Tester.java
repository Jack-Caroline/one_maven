package com.jack.java.maven.day06;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tester {
    /**
     * 测试用例
     */
    @Test
    public void test(){
        Calculator calculator = new Calculator();
        int actual = calculator.add(3,4);
        int expected = 7;
        // 断言：实际值，期望值，一致断言通过，否则断言失败；
        Assert.assertEquals(actual,expected);
    }
}
