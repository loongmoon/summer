/**
 * Project Name:summer
 * File Name:AbstractApplicationContext
 * Package Name:com.zhao.summer.context
 * Date:2018/2/6 16:41
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.context;

import com.zhao.summer.beans.factory.AbstractBeanFactory;
import javafx.application.Application;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * ClassName: AbstractApplicationContext <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/6 16:41 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
