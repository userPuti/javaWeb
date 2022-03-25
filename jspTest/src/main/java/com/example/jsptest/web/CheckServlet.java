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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Puti
 * @date 2022/3/24 10:17
 */
@WebServlet(name = "CheckServlet", value = "/checkServlet")
public class CheckServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yhid = req.getParameter("yhid");
        User user = userService.queryUserByYhid(yhid);

        if (null != user) {
            Gson gson = new Gson();
            String jUser = gson.toJson(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", jUser);
        }
    }
}
