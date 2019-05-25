package com.atguigu.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SecondRealm extends AuthenticatingRealm {

    /*模拟数据库中的用户表*/
    private static Map<String,Object> users=new HashMap<>();

    static {
        users.put("admin","ce2f6417c7e1d32c1d81a797ee0b499f87c5de06");
        users.put("sunyj","991a840fcdb6eba8127d00906809028b7ee64daf");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken uptoken= (UsernamePasswordToken) token;
        String username=uptoken.getUsername();

        //根据表单用户名 获取用户信息
        String password = (String) users.get(username);

        if(StringUtils.isEmpty(password)){
            throw  new UnknownAccountException("账户不存在");
        }


        /*用户名做颜值*/
        ByteSource credentialSalt=ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo("77439678@qq.com",users.get(username),credentialSalt,getName());

        return info;
    }

    public static void main(String[] args) {
        String algorithmName="SHA1";
        Object source="123456";
        Object salt=ByteSource.Util.bytes("admin");;
        int hashIterations=1024;
        SimpleHash result = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);
    }
}
