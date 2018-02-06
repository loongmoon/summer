/**
 * Project Name:summer
 * File Name:ApplicationContextTest
 * Package Name:com.zhao.summer.context
 * Date:2018/2/6 16:59
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.context;

import com.zhao.summer.UserService;
import org.junit.Test;

/**
 * ClassName: ApplicationContextTest <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/2/6 16:59 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.hello();
    }
}
