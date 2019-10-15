package com.jerry.shiro_test1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
public class user {
    private String id;
    private String username;
    private String password;

    private Set<role> roles;

    public user(String id, String username, String password, Set<role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
