package com.example.jsptest.service;

import com.example.jsptest.service.impl.ImplUserService;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    UserService userService = new ImplUserService();

    @Test
    void queryUserByYhidAndYhbm() {
        System.out.println(userService.queryUserByYhidAndYhbm("444", "32010002"));
    }
}