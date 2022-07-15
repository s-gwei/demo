package com.sun.pojo;

import lombok.Data;

/**
 * @description: user
 * @author: sungw
 * @create: 2022-07-14 18:32
 **/
@Data
public class User {

    private int id;

    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}
