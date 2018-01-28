package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name);

    void registryBeanDefinition(String name, BeanDefinition beanDefinition);

}
