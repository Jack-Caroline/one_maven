package com.jack.java.maven.day03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        String path = "src/test/resources/student.xml";
        List<Student> students = parseXml(path);
        for (Student student : students) {
            System.out.println(student);
        }
        //1）获取类的字节码
        //2）获取字节码去创建对象
        //3）反射得到要调用的方法对象 method
        //4）通过反射调用方法

    }

    private static List<Student> parseXml(String path) throws Exception {
        // 创建解析器 SaxReader 对象
        SAXReader reader = new SAXReader();
        // 获取 document 对象
        Document document = reader.read(new File(path));
        // 获取根元素
        Element root = document.getRootElement();
        // 获取根元素下的子元素
        List<Element> studentsElements = root.elements("student");
        List<Student> students = new ArrayList<Student>();
        Class<Student> clazz = Student.class;
        // 通过循环处理三个 student 元素
        for (Element studentElement : studentsElements) {
//            Element nameElement = studentElement.element("name");
//            Element ageElement = studentElement.element("age");
//            Element genderElement = studentElement.element("gender");
//            String name=nameElement.getText();
//            String age=ageElement.getText();
//            String gender=genderElement.getText();
            //考虑到xml文件中的元素会变动和修改后调整代码比较多，所以优化为
            List<Element> elemetns = studentElement.elements();
            Student student = clazz.newInstance();
            // 完成三个子元素的解析，并将数据封装在 Student 对象中
            for (Element element : elemetns) {
                String elementName = element.getName();
                elementName = "set" + elementName;
                Method method = clazz.getMethod(elementName, String.class);
                method.invoke(student, element.getText());
            }
            students.add(student);
        }
        return students;
    }
}
