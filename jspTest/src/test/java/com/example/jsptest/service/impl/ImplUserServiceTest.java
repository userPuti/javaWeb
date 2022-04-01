package com.example.jsptest.service.impl;

import com.example.jsptest.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplUserServiceTest {
    UserService userService = new ImplUserService();
    @Test
    void bulkDeletion() {
        String del = "108,109,11,110,111,111111,112";
        userService.bulkDeletion(del);
    }
}