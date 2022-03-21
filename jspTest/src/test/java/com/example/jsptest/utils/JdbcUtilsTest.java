package com.example.jsptest.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author puti
 * @date 2022/3/18
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {

        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
