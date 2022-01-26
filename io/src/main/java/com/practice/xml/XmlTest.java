package com.practice.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/12/12 9:26 下午
 */
public class XmlTest {

    public static void main(String[] args) throws Exception {

        InputStream resourceAsStream = XmlTest.class.getClassLoader().getResourceAsStream("test.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.parse(resourceAsStream);

    }
}
