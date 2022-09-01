package com.jack.java.maven.day03;

import org.dom4j.io.SAXReader;

public class XmlDemo {
    public static void main(String[] args) {
        String path = "src/test/java/resources/student.xml";
        parseXml(path);
    }

    private static void parseXml(String path) {
        // 创建解析器 SaxReader 对象
        SAXReader reader = new SAXReader();
        // 获取 document 对象
        Document document = reader.read(new File(path));
        // 获取根元素
        Element root = document.getRootElement();
        // 获取根元素下的子元素
        List<Element> studentsElements = root.elements("student");
        // 通过循环处理三个 student 元素
        for (Element studentElement : studentsElements) {
            Element nameElement = studentElement.element("name");
            Element ageElement = studentElement.element("age");
            Element genderElement = studentElement.element("gender");
        }
    }
}
