/**
 * Project Name:summer
 * File Name:BeanDefinitionTest
 * Package Name:com.zhao.summer
 * Date:2018/1/26 17:20
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

import com.zhao.summer.beans.BeanDefinition;
import com.zhao.summer.beans.PropertyValue;
import com.zhao.summer.beans.PropertyValues;
import com.zhao.summer.beans.factory.AbstractBeanFactory;
import com.zhao.summer.beans.factory.AutowireCapableBeanFactory;
import com.zhao.summer.beans.factory.BeanFactory;
import org.junit.Test;

/**
 * ClassName: BeanDefinitionTest <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/26 17:20 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BeanDefinitionTest {

    @Test
    public void test() throws Exception {
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        // bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.zhao.summer.UserService");

        // 设置bean属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.getPropertyValueList().add(new PropertyValue("text", "hello world"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }
    
}
