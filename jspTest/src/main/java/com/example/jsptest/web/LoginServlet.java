package com.example.jsptest.web;

import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String zh = req.getParameter("zh");
        String kl = req.getParameter("kl");
        String jzzh = req.getParameter("jzzh");
        String jzmm = req.getParameter("jzmm");

        User user = new User();
        user.setYhid(zh);
        user.setYhkl(kl);

        User loginUser = userService.login(user);

        if (loginUser != null) {
            if (jzzh != null) {
                Cookie zhanghao = new Cookie("zh", zh);
                zhanghao.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(zhanghao);
            }
            if (jzmm != null) {
                Cookie kouling = new Cookie("kl", kl);
                kouling.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(kouling);
            }
            req.getRequestDispatcher("/t1.jsp").forward(req, resp);
            System.out.println("登录成功");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("登陆失败");
        }
    }
}
