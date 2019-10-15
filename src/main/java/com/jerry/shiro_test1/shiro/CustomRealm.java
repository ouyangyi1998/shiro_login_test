package com.jerry.shiro_test1.shiro;


import com.jerry.shiro_test1.entity.permission;
import com.jerry.shiro_test1.entity.role;
import com.jerry.shiro_test1.entity.user;
import com.jerry.shiro_test1.service.loginService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private loginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        String name=(String)principalCollection.getPrimaryPrincipal();
        user user=loginService.getUserByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        for(role role:user.getRoles())
        {
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for(permission permissions:role.getPermissions())
            {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
    {
        if(authenticationToken.getPrincipal()==null)
        {
            return null;
        }
        String name=authenticationToken.getPrincipal().toString();
        user user=loginService.getUserByName(name);
        if(user==null)
        {
            return null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(name,user.getPassword().toString(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
