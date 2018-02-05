/**
 * Project Name:summer
 * File Name:AbstractBeanDefinitionReader
 * Package Name:com.zhao.summer
 * Date:2018/2/5 10:29
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

import com.zhao.summer.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AbstractBeanDefinitionReader <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/5 10:29 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
