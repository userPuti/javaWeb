package com.example.jsptest.dao;

import com.example.jsptest.dao.impl.ImplUserDao;
import com.example.jsptest.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void queryUserByUsernameAndPassword() {
        UserDao userDao = new ImplUserDao();
        User user = userDao.queryUserByUsernameAndPassword("lijiong", "123456");
        System.out.println(user);
    }
}