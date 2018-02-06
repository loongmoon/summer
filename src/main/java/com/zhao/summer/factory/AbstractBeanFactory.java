/**
 * Project Name:summer
 * File Name:AbstractBeanFactory
 * Package Name:com.zhao.summer
 * Date:2018/1/26 15:46
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    private List<String> beanDefinitionNames = new ArrayList<String>();

    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object object = doCreateBean(beanDefinition);
        beanDefinition.setBean(object);
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext(); ) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    public abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
