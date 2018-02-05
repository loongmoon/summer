package com.zhao.summer.xml;

import com.zhao.summer.BeanDefinition;
import com.zhao.summer.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * ClassName: XmlBeanDefinitionReaderTest <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/5 11:28 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class XmlBeanDefinitionReaderTest {
    @Test
    public void loadBeanDefinitions() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }

}