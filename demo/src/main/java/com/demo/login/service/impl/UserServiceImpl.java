package com.demo.login.service.impl;

import com.demo.login.dao.*;
import com.demo.login.pojo.Permission;
import com.demo.login.pojo.Role;
import com.demo.login.pojo.User;
import com.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Descripthion 用户信息
 * @Author shichuang
 * @Date 2019/10/30 8:48 下午
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * @Author shichuang
     * @Description 根据用户id查询用户所有角色
     * @Date 2019/12/24
     * @Param [userId]
     * @return java.util.List<com.demo.login.pojo.Role>
     **/
    @Override
    public List<Role> findRoles(String userId) {

        return null;
    }

    /**
     * @Author shichuang
     * @Description 根据用户id查询用户权限
     * @Date 2019/12/24 根据用户id查询用户权限
     * @Param [userId]
     * @return java.util.List<com.demo.login.pojo.Permission>
     **/
    @Override
    public List<Permission> findPermission(String userId) {
        return null;
    }

    /**
     * @Author shichuang
     * @Description 根据用户id查询用户信息
     * @Date 2019/12/24
     * @Param [userId]
     * @return com.demo.login.pojo.User
     **/
    @Override
    public User findUserByUserId(String userId) {
        return null;
    }

    /**
     * @Author shichuang
     * @Description 分配默认用户角色权限
     * @Date 2019/12/24
     * @Param [user]
     * @return int
     **/
    @Override
    public int assignDefaultUserRolePermission(User user) {
        return 0;
    }
}
