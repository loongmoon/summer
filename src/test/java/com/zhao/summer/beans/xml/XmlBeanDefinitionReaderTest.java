package com.zhao.summer.beans.xml;

import com.zhao.summer.beans.BeanDefinition;
import com.zhao.summer.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

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