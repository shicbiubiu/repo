package com.demo.login.pojo;

/**
 * @ClassName UserRole
 * @Descripthion 用户与角色关联
 * @Author shichuang
 * @Date 2019/12/24 2:16 下午
 * @Version 1.0
 **/
public class UserRole {
    private String uid;
    private String roleId;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
