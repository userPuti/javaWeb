package com.example.jsptest.service;

import com.example.jsptest.pojo.User;
import com.example.jsptest.service.impl.ImplUserService;
import org.junit.jupiter.api.Test;

class LoginServiceTest {
    UserService userService = new ImplUserService();

    @Test
    void login() {
        System.out.println(userService.login(new User("lijiong", "李炅", "123456", null,  null, null, null, null, null)));
    }
}