package com.demo.login.pojo;

/**
 * @ClassName RolePermission
 * @Descripthion 角色权限
 * @Author shichuang
 * @Date 2019/12/24 2:19 下午
 * @Version 1.0
 **/
public class RolePermission {
    private String permissionId;
    private String roleId;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
