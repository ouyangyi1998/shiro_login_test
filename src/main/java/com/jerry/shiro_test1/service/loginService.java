package com.jerry.shiro_test1.service;

import com.jerry.shiro_test1.entity.user;

public interface loginService {
    public user getUserByName(String getMapByName);
    public user getMapByName(String username);
}
