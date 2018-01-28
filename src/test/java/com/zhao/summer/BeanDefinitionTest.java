/**
 * Project Name:summer
 * File Name:BeanDefinitionTest
 * Package Name:com.zhao.summer
 * Date:2018/1/26 17:20
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

import com.zhao.summer.factory.AutoWireCapalbeBeanFactory;
import com.zhao.summer.factory.BeanFactory;
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
    public void test() {
        BeanFactory beanFactory = new AutoWireCapalbeBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.zhao.summer.UserService");
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }
    
}
