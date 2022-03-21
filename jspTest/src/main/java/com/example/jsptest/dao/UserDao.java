package com.example.jsptest.dao;

import com.example.jsptest.pojo.User;

/**
 * @author puti
 * @date 2022/3/18
 */
public interface UserDao {

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 返回null代表没有，反之则用户存在
     */
    public User queryUserByUsernameAndPassword(String username, String password);
}
