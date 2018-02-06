/**
 * Project Name:summer
 * File Name:BeanReference
 * Package Name:com.zhao.summer
 * Date:2018/2/6 15:18
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

/**
 * ClassName: BeanReference <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/6 15:18 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

}
