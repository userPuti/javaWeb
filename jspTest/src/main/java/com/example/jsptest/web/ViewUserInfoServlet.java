package com.example.jsptest.web;

import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Puti
 * @date 2022/3/24 10:17
 */
@WebServlet(name = "ViewUserInfoServlet", value = "/viewUserInfoServlet")
public class ViewUserInfoServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String yhid = req.getParameter("yhid");
        User user = userService.viewUserInfo(yhid);
        Gson gson = new Gson();
        String JUser = gson.toJson(user);
        resp.getWriter().write(JUser);
    }
}
