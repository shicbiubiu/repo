package com.demo.login.service;

import com.demo.login.pojo.Permission;
import com.demo.login.pojo.Role;
import com.demo.login.pojo.User;

import java.util.List;

/**
 * @Author shichuang
 * @Description 用户相关信息查询
 * @Date 2019/12/24
 * @Param
 * @return
 **/
public interface UserService {
    /**
     * @return java.util.List<com.example.login.pojo.Role>
     * @Author shichuang
     * @Description 根据用户id查询用户所有角色
     * @Date 2019/12/24
     * @Param [userId]
     **/
    List<Role> findRoles(String userId);

    /**
     * @return java.util.List<com.example.login.pojo.Permission>
     * @Author shichuang
     * @Description 根据用户id查询用户权限
     * @Date 2019/12/24
     * @Param [userId]
     **/
    List<Permission> findPermission(String userId);

    /**
     * @return com.example.login.pojo.User
     * @Author shichuang
     * @Description 根据用户id查询用户信息
     * @Date 2019/12/24
     * @Param [userId]
     **/
    User findUserByUserId(String userId);

    /**
     * @return int
     * @Author shichuang
     * @Description 分配默认用户角色权限
     * @Date 2019/12/24
     * @Param [user]
     **/
    int assignDefaultUserRolePermission(User user);
}
