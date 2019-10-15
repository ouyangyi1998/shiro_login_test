package com.jerry.shiro_test1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Setter
@Getter

public class role {

    private String id;

    private String roleName;


    private Set<permission> permissions;

    public role(String id, String roleName, Set<permission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }
}
