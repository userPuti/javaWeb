package com.example.jsptest.dao.impl;

import com.example.jsptest.dao.UserDao;
import com.example.jsptest.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImplUserDaoTest {
    UserDao userDao  = new ImplUserDao();

    @Test
    void countUser() {
//        int i = (int) userDao.countUser("*");
//        System.out.println(i);
//
//        int i1 = (int) userDao.countUser("32010001");
//        System.out.println(i1);
    }

    @Test
    void countYhbmUser() {
        long l = userDao.countYhbmUser("32010002");
        System.out.println(l);
    }

    @Test
    void queryUserByYhbm() {
        List<User> users = userDao.queryUserByYhbm("32010001", 0, 20);
        System.out.println(users.size());
        System.out.println(users);
    }
}