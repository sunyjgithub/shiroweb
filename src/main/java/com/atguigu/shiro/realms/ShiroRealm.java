package com.atguigu.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {

    /*模拟数据库中的用户表*/
    private static Map<String,Object> users=new HashMap<>();

    static {
        users.put("admin","038bdaf98f2037b31f1e75b5b4c9b26e");
        users.put("sunyj","b60378d3d02b7bab957d4357aee180f9");
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

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,users.get(username),credentialSalt,getName());

        return info;
    }

    public static void main(String[] args) {
        String algorithmName="MD5";
        Object source="123456";
        Object salt=ByteSource.Util.bytes("admin");;
        int hashIterations=1024;
        SimpleHash result = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);

    }


    /*授权realm*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("primaryPrincipal==="+primaryPrincipal);

        Collection collection = principals.fromRealm(getName());
        System.out.println(collection);

        Set<String> roles=new HashSet<>();
        if (primaryPrincipal.equals("sunyj")){
            roles.add("user");
        }

        if (primaryPrincipal.equals("admin")){
            roles.add("admin");
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo(roles);

        return simpleAuthorizationInfo;
    }
}
