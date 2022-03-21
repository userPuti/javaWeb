package com.example.jsptest.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

    /**
     * 查找cookie工具类
     *
     * @param name    要查找的cookie的name属性
     * @param cookies request.getCookies()
     * @return 返回对应的cookie，否则返回null
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
