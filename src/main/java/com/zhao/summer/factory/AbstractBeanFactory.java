/**
 * Project Name:summer
 * File Name:AbstractBeanFactory
 * Package Name:com.zhao.summer
 * Date:2018/1/26 15:46
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: AbstractBeanFactory <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/26 15:46 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object object = doCreateBean(beanDefinition);
        beanDefinition.setBean(object);
        beanDefinitionMap.put(name, beanDefinition);
    }

    public abstract Object doCreateBean(BeanDefinition beanDefinition);

}
