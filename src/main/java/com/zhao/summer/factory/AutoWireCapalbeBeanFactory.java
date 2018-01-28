package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;

/**
 * Created by loongmoon on 18/1/28
 */
public class AutoWireCapalbeBeanFactory extends AbstractBeanFactory {
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
