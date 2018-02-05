package com.zhao.summer;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * ClassName: BeanDefinitionReader <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/5 10:36 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException;

}
