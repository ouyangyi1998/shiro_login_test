package com.jerry.shiro_test1.service.impl;

import com.jerry.shiro_test1.entity.permission;
import com.jerry.shiro_test1.entity.role;
import com.jerry.shiro_test1.entity.user;
import com.jerry.shiro_test1.service.loginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Service
public class loginServiceImpl implements loginService {
    @Override
    public user getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }

    @Override
    public user getMapByName(String username) {
        permission permission1=new permission("1","query");
        permission permission2=new permission("2","add");
        Set<permission> permissionSet=new HashSet<>();
        permissionSet.add(permission1);
        permissionSet.add(permission2);

        role role1=new role("1","admin",permissionSet);
        Set<role> roleSet=new HashSet<>();
        roleSet.add(role1);
        user user =new user("1","wsl","123456",roleSet);
        Map<String,user> map=new HashMap<>();
        map.put(user.getUsername(),user);

        permission permission3=new permission("3","query");
        Set<permission> permissionSet1=new HashSet<>();
        permissionSet1.add(permission3);
        role role2=new role("2","user",permissionSet);
        Set<role> roleSet1=new HashSet<>();
        roleSet1.add(role2);
        user user1=new user("2","zhangsan","1234",roleSet1);
        map.put(user1.getUsername(),user1);
        return map.get(username);

    }
}
