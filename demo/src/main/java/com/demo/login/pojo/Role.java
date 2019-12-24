package com.demo.login.pojo;

/**
 * @ClassName Role
 * @Descripthion 角色
 * @Author shichuang
 * @Date 2019/12/24 2:17 下午
 * @Version 1.0
 **/
public class Role {
    private String id;
    private String description;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
