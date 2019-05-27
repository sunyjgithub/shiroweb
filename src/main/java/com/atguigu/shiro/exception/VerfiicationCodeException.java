/*******************************************************************************
 * @(#)VerfiicationCodeException.java 2018/2/27
 *
 * Copyright 2018 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.atguigu.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 认证异常
 * @author <a href="mailto:fengjian@emrubik.com">feng jian</a>
 * @version $$Revision 1.0 $$ 2018/2/27 12:11
 */
public class VerfiicationCodeException extends AuthenticationException {

    /**
     * 构造函数
     */
    public VerfiicationCodeException() {
    }

    /**
     * 构造函数
     * @param message 错误消息
     */
    public VerfiicationCodeException(String message) {
        super(message);
    }

    /**
     * 构造函数
     * @param cause 包括的其他异常
     */
    public VerfiicationCodeException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     * @param message 错误消息
     * @param cause 包括的其他异常
     */
    public VerfiicationCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
