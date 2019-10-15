package com.jerry.shiro_test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} )
public class ShiroTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(ShiroTest1Application.class, args);
    }

}
