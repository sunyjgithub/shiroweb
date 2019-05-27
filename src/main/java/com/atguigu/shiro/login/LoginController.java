package com.atguigu.shiro.login;

import com.atguigu.shiro.exception.VerfiicationCodeException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        System.out.println("get 方式請求 跳轉到登陸頁");
        return "login";
    }

    /*發生錯誤時跳轉到登陸頁 帶會登陸信息*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model){
        System.out.println("發生驗證錯誤了  才會進來");
        String exceptionName = (String) request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionName)){
            model.addAttribute("errormsg","账号不存在");
        }
        if (AuthenticationException.class.getName().equals(exceptionName)){
            model.addAttribute("errormsg","其他验正信息");
        }

        if(VerfiicationCodeException.class.getName().equals(exceptionName)){
            model.addAttribute("errormsg","验证码错误");
        }

         return "login";
    }
}
