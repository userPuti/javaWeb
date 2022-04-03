package com.example.jsptest.web;

import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        resp.setContentType("text/xml;charset=utf-8");

        String yhzh = req.getParameter("yhzh");
        String yhbm = req.getParameter("yhbm");
        int sta = Integer.parseInt(req.getParameter("start"));
        int lim = Integer.parseInt(req.getParameter("limit"));

        if ((yhzh == null || yhzh.equals("")) && (yhbm == null || yhbm.equals(""))) {
            return;
        }

        if (Objects.equals(yhbm, "lat")) {
            yhbm = "32010001";
        } else if (Objects.equals(yhbm, "ywt")) {
            yhbm = "32010002";
        } else if (Objects.equals(yhbm, "bgs")) {
            yhbm = "32010003";
        }

        String userInfo = "";

        System.out.println(userInfo);
        if (yhzh != null && !Objects.equals(yhzh, "") && !Objects.equals(yhbm, "") && yhbm != null) {
            userInfo = userService.queryUserByYhidAndYhbm(yhzh, yhbm);
            resp.getWriter().write(userInfo);
        } else if (yhzh == null || yhzh.equals("")) {
            userInfo = userService.queryUserByYhbm(yhbm,sta-1,lim);
            resp.getWriter().write(userInfo);
        } else {
            userInfo = userService.queryUserByYhid(yhzh);
            resp.getWriter().write(userInfo);
        }

        System.out.println(userInfo);
    }
}
