package com.zhao.summer.factory;

import com.zhao.summer.BeanDefinition;
import com.zhao.summer.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by loongmoon on 18/1/28
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    public Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    public void applyPropertyValues(Object bean, BeanDefinition mbd) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }

}
