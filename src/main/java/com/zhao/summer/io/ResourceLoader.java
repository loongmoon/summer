/**
 * Project Name:summer
 * File Name:ResourceLoader
 * Package Name:com.zhao.summer.io
 * Date:2018/1/31 16:18
 * Copyright (c) 2018, Neoglory-FBA All Rights Reserved.
 */
package com.zhao.summer.io;

import java.io.InputStream;
import java.net.URL;

/**
 * ClassName: ResourceLoader <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/31 16:18 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }

}
