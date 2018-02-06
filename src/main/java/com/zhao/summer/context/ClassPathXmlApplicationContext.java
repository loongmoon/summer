/**
 * Project Name:summer
 * File Name:ClassPathXmlApplicationContext
 * Package Name:com.zhao.summer.context
 * Date:2018/2/6 16:47
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.context;

import com.zhao.summer.beans.BeanDefinition;
import com.zhao.summer.beans.factory.AbstractBeanFactory;
import com.zhao.summer.beans.factory.AutowireCapableBeanFactory;
import com.zhao.summer.beans.io.ResourceLoader;
import com.zhao.summer.beans.xml.XmlBeanDefinitionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * ClassName: ClassPathXmlApplicationContext <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/6 16:47 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
