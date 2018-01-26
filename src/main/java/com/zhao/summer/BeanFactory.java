/**
 * Project Name:summer
 * File Name:BeanFactory
 * Package Name:com.zhao.summer
 * Date:2018/1/26 15:46
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: BeanFactory <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/26 15:46 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
