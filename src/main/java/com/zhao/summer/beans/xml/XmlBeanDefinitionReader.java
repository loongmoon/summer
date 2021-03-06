/**
 * Project Name:summer
 * File Name:XmlBeanDefinitionReader
 * Package Name:com.zhao.summer.beans.xml
 * Date:2018/2/5 10:26
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.beans.xml;

import com.zhao.summer.beans.AbstractBeanDefinitionReader;
import com.zhao.summer.beans.BeanDefinition;
import com.zhao.summer.BeanReference;
import com.zhao.summer.beans.PropertyValue;
import com.zhao.summer.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: XmlBeanDefinitionReader <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/5 10:26 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = getResourceLoader().getResource(location).getInputSream();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);

        Element root = doc.getDocumentElement();

        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String name = element.getAttribute("name");
                String className = element.getAttribute("class");

                BeanDefinition beanDefinition = new BeanDefinition();

                NodeList propertyNode = element.getElementsByTagName("property");
                for (int j = 0; j < propertyNode.getLength(); j++) {
                    Node property = propertyNode.item(j);
                    if (property instanceof Element) {
                        Element propertyEle = (Element) property;
                        String propertyName = propertyEle.getAttribute("name");
                        String propertyValue = propertyEle.getAttribute("value");
                        if (propertyValue != null && propertyValue.length() > 0) {
                            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
                        } else {
                            String ref = propertyEle.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                        + propertyName + "' must specify a ref or value");
                            }
                            BeanReference beanReference = new BeanReference(ref);
                            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                        }

                    }
                }

                beanDefinition.setBeanClassName(className);
                getRegistry().put(name, beanDefinition);
            }
        }

        inputStream.close();
    }
}
