/**
 * Project Name:summer
 * File Name:BeanFactoryTest
 * Package Name:com.zhao.summer
 * Date:2018/2/5 16:03
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;


import com.zhao.summer.beans.BeanDefinition;
import com.zhao.summer.beans.factory.AbstractBeanFactory;
import com.zhao.summer.beans.factory.AutowireCapableBeanFactory;
import com.zhao.summer.beans.factory.BeanFactory;
import com.zhao.summer.beans.io.ResourceLoader;
import com.zhao.summer.beans.xml.XmlBeanDefinitionReader;

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
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }

    @org.junit.Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }

}
