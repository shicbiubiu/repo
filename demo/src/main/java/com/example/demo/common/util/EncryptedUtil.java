/**
 * @ClassName: EncryptedUtil
 * @Description: 加盐加密工具类
 * @author: shic
 * @date: 2019-05-20 10:47
 */
package com.example.demo.common.util;

import org.apache.shiro.codec.Hex;

import java.security.MessageDigest;

public class EncryptedUtil {

    /**
     * 加盐字符串，长度必须为16位。
     */
    private final static String SALT = "awedfis8xqkx9mn2";

    /**
     * 生成含有加盐的密码
     */
    public static String generate(String password) {
        return generate(password, null);
    }

    /**
     * 生成含有加盐的密码
     */
    public static String generate(String password, String userName) {
        String salt = getSalt(userName);
        password = md5Hex(password + salt);
        char[] cs1 = password.toCharArray();
        char[] cs2 = salt.toCharArray();
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = cs1[i / 3 * 2];
            cs[i + 1] = cs2[i / 3];
            cs[i + 2] = cs1[i / 3 * 2 + 1];
        }
        return new String(cs).toUpperCase();
    }

    private static String getSalt(String salt) {
        if (salt == null || salt.length() == 0) {
            return EncryptedUtil.SALT;
        }
        if (salt.length() <= 16) {
            return getStringLen8(salt) + EncryptedUtil.SALT.substring(7, 15);
        } else {
            return salt.substring(4, 12) + EncryptedUtil.SALT.substring(2, 10);
        }
    }

    public static String getStringLen8(String salt) {
        if (salt.length() == 8) {
            return salt;
        }
        if (salt.length() > 8) {
            return salt.substring(1, 9);
        } else {
            return getStringLen8(salt + salt);
        }
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs = md5.toLowerCase().toCharArray();
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = cs[i];
            cs1[i / 3 * 2 + 1] = cs[i + 2];
            cs2[i / 3] = cs[i + 1];
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}
