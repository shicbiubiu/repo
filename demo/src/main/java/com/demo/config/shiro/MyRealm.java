/**
 * @ClassName: MyRealm
 * @Description: TODO(概况)
 * @author: shic
 * @date: 2019-05-20 15:53
 * MyRealm这个类继承了AuthorizingRealm，这个类的作用是两处获取信息，一处是Subject即用户传过来的信息；
 * 一处是我们提供给shiro的userService接口以获取权限信息和角色信息。
 * 拿这两个信息之后AuthorizingRealm会自动进行比较，判断用户名密码，用户权限等等
 **/
package com.demo.config.shiro;

import com.demo.common.constant.BussinessConstant;
import com.demo.login.pojo.Permission;
import com.demo.login.pojo.Role;
import com.demo.login.pojo.User;
import com.demo.login.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权方法 shiro的权限信息配置
     *
     * @param principalCollection PrincipalCollection是用户凭证信息集合
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyRealm.doGetAuthorizationInfo()");
        System.out.println("开始执行shiro权限获取....");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String loginName = (String) principalCollection.getPrimaryPrincipal();//获取用户的登录名
        List<Role> roles = userService.findRoles(loginName);
        Set<String> roleNames = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleNames.add(role.getRole());
        }
        //此处把当前subject对应的所有角色信息交给shiro，调用hasRole的时候就根据这些role信息判断
        authorizationInfo.setRoles(roleNames);
        List<Permission> permissions = userService.findPermission(loginName);
        Set<String> permissionNames = new HashSet<>(permissions.size());
        for (Permission permission : permissions) {
            permissionNames.add(permission.getName());
        }
        //此处把当前subject对应的权限信息交给shiro，当调用hasPermission的时候就会根据这些信息判断
        authorizationInfo.setStringPermissions(permissionNames);
        System.out.println("shiro获取权限如下:" + authorizationInfo.getStringPermissions().toString());
        System.out.println("shiro权限获取成功...");
        return authorizationInfo;
    }

    /**
     * 认证方法 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
     *
     * @param authenticationToken AuthenticationToken是我们可以自己实现的用户凭证/密钥信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证-->MyRealm.doGetAuthenticationInfo()");
        String loginName = (String) authenticationToken.getPrincipal();//获取用户的登录名
        User user = userService.findUserByUserId(loginName);
        if (user == null) {
            return null;
        }
        if (BussinessConstant.ACCOUNT_STATE.STOP.equals(user.getState())) {//2表示账户停用
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user,//认证的实体信息，可以是loginName登录名，也可以是数据库表对应的用户的实体对象
                user.getPassword(),//密码
                ByteSource.Util.bytes(user.getLoginName()),//salt
                getName()//当前realm对象的name，调用父类的getName()方法即可
        );
        //authenticationInfo信息交给shiro，调用login的时候会自动比较这里的token和authenticationInfo
        return simpleAuthenticationInfo;
    }
}
