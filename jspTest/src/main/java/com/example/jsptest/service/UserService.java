package com.example.jsptest.service;

import com.example.jsptest.pojo.User;

/**
 * @author puti
 * @date 2022/3/18
 */
public interface UserService {
    /**
     * 登录
     * @param user 传入User对象
     * @return 返回User对象
     */
    public User login(User user);
}
