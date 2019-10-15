package com.jerry.shiro_test1.controller;

import com.jerry.shiro_test1.entity.user;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginServlet {
    @RequestMapping("/login")
    public String login(user user)
    {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(
        user.getUsername(),user.getPassword());
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e)
        {
            e.printStackTrace();
            return"账号密码错误";
        }catch (AuthorizationException e)
        {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index()
    {
        return "index!";
    }

}
