package com.jack.java.maven.day06;

import org.testng.annotations.Test;

public class DependencyDemo {
    @Test
    public void b() {
        System.out.println("DependencyDemo.b()");
    }

    @Test(dependsOnMethods = "b")
    public void a() {
        System.out.println("DependencyDemo.a()");
    }

}
