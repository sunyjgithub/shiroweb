package com.atguigu.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @description:
 * @author: sunyingji
 * @create: 2019-05-27 20:31
 **/
public class IDMLoginToken extends UsernamePasswordToken {

    /**
     * 验证码
     */
    private String captcha;


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public IDMLoginToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }
}
