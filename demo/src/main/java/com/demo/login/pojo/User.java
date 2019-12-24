package com.demo.login.pojo;

/**
 * @ClassName User
 * @Descripthion 用户表
 * @Author shichuang
 * @Date 2019/12/24 2:11 下午
 * @Version 1.0
 **/
public class User {
    private String id;//主键id
    private String name;//姓名
    private String mob;//手机号
    private String email;//邮箱;
    private String valid;
    private String pticket;
    private String roleId;

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

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getPticket() {
        return pticket;
    }

    public void setPticket(String pticket) {
        this.pticket = pticket;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
