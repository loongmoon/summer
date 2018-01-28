/**
 * Project Name:summer
 * File Name:UserService
 * Package Name:com.zhao.summer
 * Date:2018/1/26 17:18
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer;

/**
 * ClassName: UserService <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/26 17:18 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class UserService {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void hello() {
        System.out.println(text);
    }
}
