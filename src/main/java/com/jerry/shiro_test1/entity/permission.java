package com.jerry.shiro_test1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
public class permission {

    private String id;
    private String permissionsName;
    public permission(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }
}
