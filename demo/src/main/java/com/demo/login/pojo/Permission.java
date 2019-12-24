package com.demo.login.pojo;

/**
 * @ClassName Permission
 * @Descripthion 权限
 * @Author shichuang
 * @Date 2019/12/24 2:21 下午
 * @Version 1.0
 **/
public class Permission {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
