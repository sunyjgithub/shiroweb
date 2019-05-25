package com.atguigu.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String,String> buildFilterChainDefinitionMap(){

        /*      /login.jsp = anon
                /favicon.ico = anon
                /user.jsp=roles[user]
                /logout=logout

                /** = authc*/
        LinkedHashMap<String,String> map=new LinkedHashMap<>();
        map.put("/login.jsp","anon");
        map.put("/favicon.ico","anon");
        map.put("/user.jsp","roles[user]");
        map.put("/logout","logout");
        map.put("/**","authc");
        return map;

    }
}
