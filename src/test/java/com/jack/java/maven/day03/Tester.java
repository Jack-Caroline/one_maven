package com.jack.java.maven.day03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
    public static void main(String[] args) throws Exception {
        //获取一个类的字节码
        //方式一
        Class<Student> clazz = Student.class;
        //方式二
        Class<Student> clazz1 = (Class<Student>) Class.forName("com.jack.java.maven.day03.Student");
        //3、通过字节码通用 newInstance 方法创建对象，底层其实调用的是自己吗对应类中默认的构造函数；
        Student student = clazz.newInstance();
        //4、通过反射获取我们要调用的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method setNsmeMethods = clazz.getMethod("setName", String.class);
        //5、通过反射完成方法调用
        setNsmeMethods.invoke(student, "张三");
        //6、通过getName取出来数据
        Method getNameMethod = clazz.getMethod("getName");
        Object value = getNameMethod.invoke(student);
        System.out.println("name="+value.toString());
    }
}
