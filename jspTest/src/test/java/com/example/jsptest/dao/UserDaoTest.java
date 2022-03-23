package com.example.jsptest.dao;

import com.example.jsptest.dao.impl.ImplUserDao;
import com.example.jsptest.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao = new ImplUserDao();

    @Test
    void queryUserByUsernameAndPassword() {

        User user = userDao.queryUserByUsernameAndPassword("lijiong", "123456");
        System.out.println(user);
    }

    @Test
    void queryAllUser() {
        System.out.println(userDao.queryAllUser());
    }


    @Test
    void insertUser() {
        User user = new User("11111","Anny","abcdef","09_00003-1","32010001","19971123","2022-3-8 10:03:21","2022-3-8","1",3);
        userDao.insertUser(user);
    }

    @Test
    void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("lijiong"));
    }

    @Test
    void queryUserByYhbm() {
        System.out.println(userDao.queryUserByYhbm("32010001"));
    }

    @Test
    void queryUserByYhidAndYhbm() {
        System.out.println(userDao.queryUserByYhidAndYhbm("lijiong","32010001"));
    }
}