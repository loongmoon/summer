package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
