package com.example.jsptest.service.impl;

import com.example.jsptest.dao.UserDao;
import com.example.jsptest.dao.impl.ImplUserDao;
import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;

/**
 * @author puti
 * @date 2022/3/18
 */
public class ImplUserService implements UserService {

    private final UserDao userDao = new ImplUserDao();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getYhid(), user.getYhkl());
    }
}
