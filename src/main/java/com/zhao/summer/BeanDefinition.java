/**
 * Project Name:summer
 * File Name:BeanDefinition
 * Package Name:com.zhao.summer
 * Date:2018/1/26 15:44
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

/**
 * ClassName: BeanDefinition <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/26 15:44 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
