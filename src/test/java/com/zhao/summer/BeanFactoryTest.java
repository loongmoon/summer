/**
 * Project Name:summer
 * File Name:BeanFactoryTest
 * Package Name:com.zhao.summer
 * Date:2018/2/5 16:03
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;


import com.zhao.summer.factory.AutowireCapableBeanFactory;
import com.zhao.summer.factory.BeanFactory;
import com.zhao.summer.io.ResourceLoader;
import com.zhao.summer.xml.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * ClassName: BeanFactoryTest <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/5 16:03 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BeanFactoryTest {

    @org.junit.Test
    public void test() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }

}
