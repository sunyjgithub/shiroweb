package com.atguigu.shiro.filter;

import com.atguigu.shiro.token.IDMLoginToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import sun.security.util.Password;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: 登录验证过滤器
 * @author: sunyingji
 * @create: 2019-05-27 20:21
 **/
public class SRFormAuthenticationFilter extends FormAuthenticationFilter {



    /**
     * 创建Token拦截方法
     * @param request 登录请求
     * @param response 登录应答
     * @return 生成好的Token
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
            String username = null;
            String password = null;
            username = getUsername(request);
            password = getPassword(request);
            boolean rememberMe = isRememberMe(request);
            String captcha = WebUtils.getCleanParam(request, "validateCode");
            return new IDMLoginToken(username, password.toCharArray(), rememberMe, null, captcha);
    }
}
