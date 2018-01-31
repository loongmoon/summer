/**
 * Project Name:summer
 * File Name:Test
 * Package Name:com.zhao.summer
 * Date:2018/1/29 20:00
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * ClassName: Test <br/>
 * Function: 语法test <br/>
 * date: 2018/1/29 20:00 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
//        URL url = Test.class.getClassLoader().getResource("tinyioc.xml");
//        URLConnection urlConnection = url.openConnection();
//        urlConnection.connect();
//        InputStream inputStream = urlConnection.getInputStream();

//        File file3 = new File(Test.class.getResource("file3.txt").getFile());
        InputStream inputStream = new FileInputStream(new File(Test.class.getClassLoader().getResource("tinyioc.xml").getFile()));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);

        Element root = doc.getDocumentElement();
        NodeList nl = root.getChildNodes();
        System.out.println(nl);

    }
}
