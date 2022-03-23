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
import java.util.List;

/**
 * @author puti
 * @date 2022/3/22
 */
@WebServlet(name = "DisplayUserInfoServlet", value = "/displayUserInfoServlet")
public class DisplayUserInfoServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<User> users = userService.userInfoDisplay();
//        HttpSession session = req.getSession();
        if (users != null && users.size() != 0) {
            Gson gson = new Gson();
            String jUsers = gson.toJson(users);
//            session.setAttribute("jUsers", jUsers);
            resp.getWriter().write(jUsers);
//            System.out.println(jUsers);
        }
    }
}
