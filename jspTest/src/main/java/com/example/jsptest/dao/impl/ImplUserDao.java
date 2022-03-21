package com.example.jsptest.dao.impl;

import com.example.jsptest.dao.BaseDao;
import com.example.jsptest.dao.UserDao;
import com.example.jsptest.pojo.User;

/**
 * @author puti
 * @date 2022/3/18
 */
public class ImplUserDao extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where yhid = ? and yhkl = ?";
        return (User) queryForOne(User.class, sql, username, password);
    }
}
