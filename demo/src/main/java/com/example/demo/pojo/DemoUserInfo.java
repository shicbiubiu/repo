/**
 * @ClassName: demoUser
 * @Description: 用户信息
 * @author: shic
 * @date: 2019-04-21 17:19
 */
package com.example.demo.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DemoUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private int userAge;

    @Column(nullable = false, unique = true)
    private String userSex;

}
