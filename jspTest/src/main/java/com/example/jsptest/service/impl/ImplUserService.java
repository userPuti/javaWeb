package com.example.jsptest.service.impl;

import com.example.jsptest.dao.UserDao;
import com.example.jsptest.dao.impl.ImplUserDao;
import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;

import java.util.List;

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

    @Override
    public List<User> userInfoDisplay() {
        return userDao.queryAllUser();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User对象
     */
    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    /**
     * 根据用户部门查询用户
     *
     * @param yhbm 用户部门
     * @return List<User>对象
     */
    @Override
    public List<User> queryUserByYhbm(String yhbm) {
        return userDao.queryUserByYhbm(yhbm);
    }

    /**
     * 根据用户id和用户部门查询用户
     *
     * @param yhid 用户id
     * @param yhbm 用户部门
     * @return User对象
     */
    @Override
    public User queryUserByYhidAndYhbm(String yhid, String yhbm) {
        return userDao.queryUserByYhidAndYhbm(yhid,yhbm);
    }
}
