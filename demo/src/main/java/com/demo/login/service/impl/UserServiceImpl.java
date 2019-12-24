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

    @Override
    public List<Role> findRoles(String userId) {
        return null;
    }

    @Override
    public List<Permission> findPermission(String userId) {
        return null;
    }

    @Override
    public User findUserByUserId(String userId) {
        return null;
    }

    @Override
    public int assignDefaultUserRolePermission(User user) {
        return 0;
    }
}
