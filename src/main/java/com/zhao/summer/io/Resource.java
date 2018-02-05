package com.zhao.summer.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: Resource <br/>
 * Function: ${DESCRIPTION} <br/>
 * date: 2018/1/31 15:45 <br/>
 *
 * @author zhaob
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface Resource {

    /**
     * 获取数据流
     * @return 数据流
     */
    InputStream getInputSream() throws IOException;

}
