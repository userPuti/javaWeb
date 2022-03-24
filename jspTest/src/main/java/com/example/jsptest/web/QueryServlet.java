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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Puti
 * @date 2022/3/23
 * @time 15:32
 */
@WebServlet(name = "QueryServlet", value = "/queryServlet")
public class QueryServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String yhzh = req.getParameter("yhzh");
        String yhbm = req.getParameter("yhbm");

        if (Objects.equals(yhbm, "lat")) {
            yhbm = "32010001";
        } else if (Objects.equals(yhbm, "ywt")) {
            yhbm = "32010002";
        } else if (Objects.equals(yhbm, "bgs")) {
            yhbm = "32010003";
        }

        User user = new User();
        List<User> users = new ArrayList<>();

        Gson gson = new Gson();

        if (yhzh != null && !Objects.equals(yhzh, "") && !Objects.equals(yhbm, "blank") && yhbm != null) {
            user = userService.queryUserByYhidAndYhbm(yhzh, yhbm);
            users.add(user);
            String jusers = gson.toJson(users);
            resp.getWriter().write(jusers);

        } else if (yhzh == null || Objects.equals(yhzh, "")) {
            users = userService.queryUserByYhbm(yhbm);
            String jusers = gson.toJson(users);
            resp.getWriter().write(jusers);

        } else {
            user = userService.queryUserByYhid(yhzh);
            String juser = gson.toJson(user);
            users.add(user);
            String jusers = gson.toJson(users);
            resp.getWriter().write(jusers);

        }
    }
}
