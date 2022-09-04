package com.jack.java.maven.day06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersDemo {
    @Test(dataProvider = "dataProvider0")
    public void test(String name, int age, String gender) {
        System.out.println("name=" + name + ", age=" + age + ", gender=" + gender);
    }

    @DataProvider(name = "aa")
    public Object[][] dataProvider0() {
        Object[][] datas = {{"张三", 28, "男"},
                {"李四", 29, "女"}};
        return datas;
    }

    @DataProvider(name = "bb")
    public Object[][] dataProvider1() {
        Object[][] datas = {{"王五", 30, "男"},
                {"赵六", 31, "女"}};
        return datas;
    }
}
