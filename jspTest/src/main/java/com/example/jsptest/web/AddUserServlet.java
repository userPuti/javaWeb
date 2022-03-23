package com.example.jsptest.web;

import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author puti
 * @date 2022/3/22
 */
@WebServlet(name = "AddUserServlet", value = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String yhbm = req.getParameter("yhbm");
        String xb = req.getParameter("xb");
        String sfjy = req.getParameter("sfjy");
        String csrq = req.getParameter("csrq").replaceAll("-", "");

        User user = new User();
        user.setYhid(req.getParameter("yhidText"));
        user.setYhxm(req.getParameter("yhxmText"));
        user.setYhkl(req.getParameter("yhklText"));

        if (Objects.equals(yhbm, "lat")) {
            user.setYhbm("32010001");
        } else if (Objects.equals(yhbm, "ywt")) {
            user.setYhbm("32010002");
        } else {
            user.setYhbm("32010003");
        }

        if (Objects.equals(xb, "male")) {
            user.setYhxb("09_00003-1");
        } else if (Objects.equals(xb, "female")) {
            user.setYhxb("09_00003-2");
        } else {
            user.setYhxb("09_00003-255");
        }

//        SimpleDateFormat csrq = new SimpleDateFormat("yyyyMMdd");
        user.setCsrq(csrq);
        user.setPxh(Integer.parseInt(req.getParameter("pxhText")));

        if (sfjy.equals("on")) {
            user.setSfjy("1");
        } else {
            user.setSfjy("0");
        }

        Date date = new Date();
        SimpleDateFormat djrq = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat djsj = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        user.setDjrq(djrq.format(date));
        user.setDjsj(djsj.format(date));

        int rows = userService.insertUser(user);

        if (rows == 1) {
            req.getRequestDispatcher("/t1.jsp").forward(req, resp);
        } else {
            System.out.println("添加失败");
        }
    }
}
